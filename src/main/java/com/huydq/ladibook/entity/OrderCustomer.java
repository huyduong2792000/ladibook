package com.huydq.ladibook.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_customer")
public class OrderCustomer extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "compute_order_id_customer_id", nullable = false, unique = true)
	private long id;

	@Column(name = "email", nullable = false)
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

	@Column(name = "description")
	private String description;

	@Column(name = "buy_date")
	private Date buyDate;

	@Column(name = "status")
	private String status = "create"; // create, processing, done

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "landingpage_id")
	private LandingPage landingPage;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User employee;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "order_id", nullable = false)
	Order order;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id", nullable = false)
	Customer customer;
}
