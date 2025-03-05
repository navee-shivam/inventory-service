package com.ng.inventory.dto;

import java.util.List;

import lombok.Data;

@Data
public class PaginationCustomizedResponse<T> {
	private List<T> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
}
