package com.ng.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ng.inventory.entity.Suppliers;

public interface SupplierRepository extends JpaRepository<Suppliers, Long> {

}
