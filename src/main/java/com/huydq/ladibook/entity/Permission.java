package com.huydq.ladibook.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permission_id", nullable = false, unique = true)
	private long permissionId;

	@Column(name = "permission_no", nullable = false)
	private String permissionNo;

	@Column(name = "permission_name", nullable = false)
	private String permissionName;

	@ManyToMany(mappedBy = "permissions", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}
}
