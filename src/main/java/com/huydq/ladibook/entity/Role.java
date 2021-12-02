package com.huydq.ladibook.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false, unique = true)
	private long roleId;

	@Column(name = "role_name", nullable = false)
	private String roleName;

	@OneToMany(mappedBy = "role")
	private List<User> users;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "role_permission", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "permission_id") })
	Set<Permission> permissions = new HashSet<>();

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void addPermission(Permission permission) {
		permissions.add(permission);
		permission.getRoles().add(this);
	}

	public void removePermission(Permission permission) {
		this.permissions.remove(permission);
		permission.getRoles().remove(this);
	}
}
