package com.huydq.ladibook.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false, unique = true)
	private long id;

	@Column(name = "buy_date")
	private Date buyDate;

	@Column(name = "status")
	private String status = "CREATED"; // CREATED, PROCESSING, DONE

	@Column(name = "is_paid")
	private boolean isPaid = false; // Đã thanh toán hay chưa

	@Column(name = "description")
	private String description;

	@Column(name = "price_total")
	private float priceTotal = 0;

	@Column(name = "quantily")
	private float quantily = 0;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id", nullable = false)
//	private User employee;
//
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "landingpage_id")
//	private LandingPage landingPage;

//	@OneToMany(mappedBy = "order")
//	private List<OrderProduct> products;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderCustomer> customers;
//
//	public void addOrderCustomer(OrderCustomer orderCustomer) {
//		this.customers.add(orderCustomer);
//	}
}
