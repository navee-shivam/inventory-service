package com.ng.inventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ng.inventory.entity.Items;

@Repository
public interface InventoryRepository extends PagingAndSortingRepository<Items, Long> {

	Page<Items> findByCategory_Name(String categoryName, Pageable page);

	Page<Items> findBySupplier_Name(String supplierName, Pageable page);

	Page<Items> findBySupplier_NameAndCategory_Name(String supplierName, String categoryName, Pageable page);
}
