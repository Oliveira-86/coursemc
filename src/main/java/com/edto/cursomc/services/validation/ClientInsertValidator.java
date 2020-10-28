package com.edto.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.edto.cursomc.domain.Client;
import com.edto.cursomc.domain.enums.ClientType;
import com.edto.cursomc.dto.ClientNewDTO;
import com.edto.cursomc.repositories.ClientRepository;
import com.edto.cursomc.resources.exceptions.FieldMessage;
import com.edto.cursomc.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {
	
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getCpfOuCnpj().equals(ClientType.PHYSICALPERSON.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "Invalid CPF"));
		}
		
		if (objDto.getCpfOuCnpj().equals(ClientType.LEGALPERSON.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "Invalid CNPJ"));
		}
		
		Client aux = repository.findByEmail(objDto.getEmail());
		if(aux.getEmail()!=null) {
			list.add(new FieldMessage("Email", "Existing Email!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}