package com.ng.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ng.inventory.entity.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Long> {

}
