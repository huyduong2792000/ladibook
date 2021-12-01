package com.huydq.ladibook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "user")
public class User extends Base {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, unique = true)
	private long userId;

	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "full_name")
	private String fullname;
	
	@Column(name = "phone", unique = true)
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "gender")
	private boolean gender;
	
	@Column(name = "verify")
	private boolean verify;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@Column(name = "avatar")
	private String avatar;


}
