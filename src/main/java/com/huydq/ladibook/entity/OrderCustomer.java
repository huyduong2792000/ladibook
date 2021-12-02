package com.huydq.ladibook.entity;

import java.io.Serializable;

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
class OrderCustomerKey implements Serializable {

	@Column(name = "order_id")
	Long orderId;

	@Column(name = "customer_id")
	Long customerId;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_customer")
public class OrderCustomer extends Base {

	@EmbeddedId
	OrderCustomerKey id;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "full_name")
	private String fullname;

	@Column(name = "phone", unique = true)
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "gender")
	private String gender;

	@Column(name = "avatar")
	private String avatar;

	@ManyToOne
	@MapsId("orderId")
	@JoinColumn(name = "order_id", nullable = false)
	Order order;

	@ManyToOne
	@MapsId("customerId")
	@JoinColumn(name = "customer_id", nullable = false)
	Customer customer;
}
