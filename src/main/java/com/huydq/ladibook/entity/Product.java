package com.huydq.ladibook.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@Setter
@Getter
public class Product extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false, unique = true)
	private long id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "quantity")
	private float quantity;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "price")
	private String price;

	@Column(name = "price_label")
	private String priceLabel;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "product_type_id")
	private ProductType productType;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<ProductPrice> productPrices;

}
