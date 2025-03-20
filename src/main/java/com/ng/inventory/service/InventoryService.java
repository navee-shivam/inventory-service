package com.ng.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ng.inventory.dto.InventoryItemResponseDto;
import com.ng.inventory.dto.InventoryRequestDto;
import com.ng.inventory.dto.ItemRequestDto;
import com.ng.inventory.entity.Items;
import com.ng.inventory.repository.ItemRepository;

@Service
public class InventoryService {

	private final ItemRepository itemRepository;

	@Autowired
	public InventoryService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public Page<InventoryItemResponseDto> doFetch(int pageNo, int size, InventoryRequestDto inventoryRequestDto) {
		Pageable page = PageRequest.of(pageNo, size);

		return getFilteredData(inventoryRequestDto, page);

	}

	@Transactional(readOnly = true)
	private Page<InventoryItemResponseDto> getFilteredData(InventoryRequestDto inventoryRequestDto, Pageable page) {

		String supplier = inventoryRequestDto != null ? inventoryRequestDto.getSupplier() : null;
		String category = inventoryRequestDto != null ? inventoryRequestDto.getCategory() : null;

		boolean hasSupplier = supplier != null && !supplier.isEmpty();
		boolean hasCategory = category != null && !category.isEmpty();

		Page<Items> itemList;

		if (hasSupplier && hasCategory) {
			itemList = itemRepository.findBySupplier_NameAndCategory_Name(inventoryRequestDto.getSupplier(),
					inventoryRequestDto.getCategory(), page);
		} else if (hasCategory) {
			itemList = itemRepository.findByCategory_Name(inventoryRequestDto.getCategory(), page);
		} else if (hasSupplier) {
			itemList = itemRepository.findBySupplier_Name(inventoryRequestDto.getSupplier(), page);
		} else {
			itemList = itemRepository.findAll(page);
		}
		return itemList.map(this::mapToresponseDto);
	}

	private InventoryItemResponseDto mapToresponseDto(Items items) {
		return new InventoryItemResponseDto(items.getItemId(), items.getName(), items.getDescription(),
				items.getQuantity(), items.getCategory().getName(), items.getCategory().getCategoryId(),
				items.getSupplier().getName(), items.getSupplier().getSupplierId(), items.getPrice());
	}

	public Items doSave(ItemRequestDto itemRequestDto) {
		Items items = Items.builder().name(itemRequestDto.getName()).description(itemRequestDto.getDescription())
				.quantity(itemRequestDto.getQuantity()).price(itemRequestDto.getPrice())
				.location(itemRequestDto.getLocation()).thresholdQty(itemRequestDto.getThresholdQty()).build();
		return itemRepository.save(items);
	}

	public void doDelete(Long id) {
		itemRepository.deleteById(id);
	}

}
