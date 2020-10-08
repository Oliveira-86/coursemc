package com.edto.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edto.cursomc.domain.Address;
import com.edto.cursomc.domain.City;
import com.edto.cursomc.domain.Client;
import com.edto.cursomc.domain.enums.ClientType;
import com.edto.cursomc.dto.ClientDTO;
import com.edto.cursomc.dto.ClientNewDTO;
import com.edto.cursomc.repositories.AddressRepository;
import com.edto.cursomc.repositories.ClientRepository;
import com.edto.cursomc.services.exceptions.DataIntegrityException;
import com.edto.cursomc.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<Client> findAll() {
		List<Client> list = repository.findAll();
		return list;
	}
	
	public Client findbyId(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	@Transactional
	public Client insert(Client obj) {
		obj = repository.save(obj);
		addressRepository.saveAll(obj.getAddress());
		return obj;
	}

	public Client update(Client obj) {
		Client newObj = findbyId(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	public void delete(Long id) {
		findbyId(id); 
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Is not possible delete, association between Entities");
		}
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public Client fromDTO(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}
	
	public Client fromDTO(ClientNewDTO objDto) {
		Client cli = new Client(null, objDto.getName(), objDto.getEmail(), objDto.getCpfOuCnpj(), ClientType.toEnum(objDto.getType()));
		City city = new City(objDto.getCidadeId(), null, null);
		Address add = new Address(null, objDto.getPublicPlace(), objDto.getNumber(), objDto.getComplement(), objDto.getNeighborhood(), objDto.getZipCode(), cli, city);
		cli.getAddress().add(add);
		cli.getPhone().add(objDto.getPhone1());
		if(objDto.getPhone2()!=null) {
			cli.getPhone().add(objDto.getPhone2());
		}
		if(objDto.getPhone3()!=null) {
			cli.getPhone().add(objDto.getPhone3());
		}
		return cli;
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	
}
