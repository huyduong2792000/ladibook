package com.huydq.ladibook.entity;

import java.io.Serializable;

//
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
class OrderProductKey implements Serializable {

	@Column(name = "order_id")
	Long orderId;

	@Column(name = "product_id")
	Long productId;

}

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_product")
public class OrderProduct extends Base {

	@EmbeddedId
	OrderProductKey id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private float price;

	@Column(name = "price_unit")
	private String priceUnit;

	@Column(name = "quantity")
	private float quantity;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@ManyToOne
	@MapsId("orderId")
	@JoinColumn(name = "order_id", nullable = false)
	Order order;

	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "product_id", nullable = false)
	Price product;
}
