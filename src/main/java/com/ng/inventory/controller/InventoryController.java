package com.ng.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ng.inventory.dto.InventoryItemResponseDto;
import com.ng.inventory.dto.InventoryRequestDto;
import com.ng.inventory.service.InventoryService;

@RestController
@RequestMapping("v1/inventory")
public class InventoryController {

	private final InventoryService inventoryService;

	@Autowired
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@GetMapping("/fetch")
	public ResponseEntity<Page<InventoryItemResponseDto>> doFetch(
			@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestBody(required = false) InventoryRequestDto inventoryRequestDto) {
		return new ResponseEntity<Page<InventoryItemResponseDto>>(
				inventoryService.doFetch(pageNo, size, inventoryRequestDto), HttpStatus.OK);
	}

}
