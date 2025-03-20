package com.ng.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ng.inventory.repository.SupplierRepository;

@Service
public class SupplierService {

	private final SupplierRepository supplierRepository;

	@Autowired
	public SupplierService( SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}
	
	
}
