package com.ng.inventory.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "suppliers")
@Data
public class Suppliers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private Long supplierId;

	@Column(name = "name")
	private String name;

	@Column(name = "contact_details")
	private String contactDetails;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
	private List<Items> items;
}
