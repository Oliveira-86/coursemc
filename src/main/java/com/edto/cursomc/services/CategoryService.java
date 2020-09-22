package com.edto.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edto.cursomc.domain.Category;
import com.edto.cursomc.repositories.CategoryRepository;
import com.edto.cursomc.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		List<Category> list = repository.findAll();
		return list;
	}
	
	public Category findbyId(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
