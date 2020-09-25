package com.edto.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.edto.cursomc.domain.Category;
import com.edto.cursomc.repositories.CategoryRepository;
import com.edto.cursomc.services.exceptions.DataIntegrityException;
import com.edto.cursomc.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		List<Category> list = repository.findAll();
		return list;
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Category insert(Category obj) {
		return repository.save(obj);
	}

	public Category update(Category obj) {
		findById(obj.getId());
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id); 
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Is not possible delete Category with Product");
		}
		
	}
}
