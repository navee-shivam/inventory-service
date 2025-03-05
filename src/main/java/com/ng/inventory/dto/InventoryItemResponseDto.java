package com.ng.inventory.dto;

import java.math.BigDecimal;

import com.ng.inventory.entity.Items;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InventoryItemResponseDto {

	private Long itemId;

	private String name;

	private String description;

	private Integer quantity;

	private String category;

	private Long categoryId;

	private String supplier;

	private Long supplierId;

	private BigDecimal price;

//	public static InventoryItemResponseDto fromEntity(Items item) {
//		return new InventoryItemResponseDto(item.getItemId(), item.getName(), item.getDescription(), item.getQuantity(),
//				item.getCategory() != null ? item.getCategory().getName() : null,
//				item.getCategory() != null ? item.getCategory().getCategoryId() : null,
//				item.getSupplier() != null ? item.getSupplier().getName() : null,
//				item.getSupplier() != null ? item.getSupplier().getSupplierId() : null, item.getPrice());
//	}

}
