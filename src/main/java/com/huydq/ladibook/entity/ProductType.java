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
	private long id;

	@Column(name = "product_type_name", nullable = false)
	private String productTypeName;

	@Column(name = "product_type_no", nullable = false, unique = true)
	private String productTypeNo = "product"; // voucher, freeship, product, combo

	@Column(name = "description")
	private String description;

	@Column(name = "is_default")
	private boolean isDefault = false;

	public ProductType(String productTypeNo, String productTypeName, String description) {
		super();
		this.productTypeNo = productTypeNo;
		this.productTypeName = productTypeName;
		this.description = description;
	}
}
