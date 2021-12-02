package com.huydq.ladibook.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
class ProductPriceKey implements Serializable {

	@Column(name = "product_id")
	Long productId;

	@Column(name = "price_id")
	Long priceId;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_price", indexes = {
		@Index(name = "unique_price_id_product_id", columnList = "price_id, product_id", unique = true) })
public class ProductPrice {

	@EmbeddedId
	ProductPriceKey id;

	@ManyToOne
	@MapsId("priceId")
	@JoinColumn(name = "price_id")
	Price price;

	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "product_id")
	Price product;

	@Column(name = "price_value")
	private float priceValue;

	@Column(name = "price_percent")
	private float pricePercent;

	@Column(name = "price_name")
	private float priceName;
}
