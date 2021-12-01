package com.huydq.ladibook.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_type")
public class ProductType extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_type_id", nullable = false, unique = true)
	private long productTypeId;

	@Column(name = "product_type_name", nullable = false)
	private String productTypeName;

	@Column(name = "description")
	private String description;

	@Column(name = "is_default")
	private boolean idDefault = false;

}