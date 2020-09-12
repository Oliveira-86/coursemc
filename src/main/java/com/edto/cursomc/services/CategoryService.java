package com.edto.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edto.cursomc.domain.Category;
import com.edto.cursomc.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		List<Category> list = repository.findAll();
		return list;
	}
	
	public Category findbyId(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
