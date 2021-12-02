package com.huydq.ladibook.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private long customerId;

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

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer referralBy;

	@OneToMany(mappedBy = "referralBy")
	private Set<Customer> referrals = new HashSet<>();
}
