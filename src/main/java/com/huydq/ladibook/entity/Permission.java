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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permission_id", nullable = false, unique = true)
	private long id;

	@Column(name = "permission_no", nullable = false)
	private String permissionNo;

	@Column(name = "permission_name", nullable = false)
	private String permissionName;

	@ManyToMany(targetEntity = Role.class, mappedBy = "permissions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public Permission(String permissionNo, String permissionName) {
		super();
		this.permissionNo = permissionNo;
		this.permissionName = permissionName;
	}

}
