package com.ng.inventory.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemRequestDto {

	private String name;

	private String description;

	private Integer quantity;

	private Long categoryId;

	private Long supplierId;

	private BigDecimal price;

	private String location;

	private Integer thresholdQty;
}
