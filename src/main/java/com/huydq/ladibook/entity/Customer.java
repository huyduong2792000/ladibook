package com.huydq.ladibook.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer", indexes = { @Index(name = "unique_email_phone", columnList = "email, phone", unique = true) })
public class Customer extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", nullable = false, unique = true)
	private long id;

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

	@Column(name = "lastBuyDate")
	private Date lastBuyDate;

//	@ManyToOne(fetch = FetchType.LAZY)
//	private Customer referralBy;
//
//	@OneToMany(mappedBy = "referralBy", fetch = FetchType.LAZY)
//	private Set<Customer> referrals = new HashSet<>();

//	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//	private Set<OrderCustomer> orders = new HashSet<>();
}
