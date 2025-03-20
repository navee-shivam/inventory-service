package com.ng.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ng.inventory.repository.CategoryRepository;
import com.ng.inventory.repository.ItemRepository;
import com.ng.inventory.repository.SupplierRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
}
