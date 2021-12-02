package com.huydq.ladibook.entity;


import java.sql.Date;
import java.util.List;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class Order extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false, unique = true)
	private long orderId;

	@Column(name = "buy_date")
	private Date buyDate;

	@Column(name = "status")
	private String status;

	@Column(name = "price_total")
	private float priceTotal;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User employee;

	@OneToMany(mappedBy = "order")
	private List<OrderProduct> products;

	@OneToMany(mappedBy = "order")
	private List<OrderCustomer> customers;

}
