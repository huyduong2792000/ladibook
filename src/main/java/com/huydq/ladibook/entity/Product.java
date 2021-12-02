package com.huydq.ladibook.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false, unique = true)
	private long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "quantity")
	private float quantity;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "product_type_id")
	private ProductType productType;

	@OneToMany(mappedBy = "product")
	Set<ProductPrice> productPrices;

}
