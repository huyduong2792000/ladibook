package com.huydq.ladibook.entity;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "role")
public class Role extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false, unique = true)
	public long roleId;

	@Column(name = "role_name", nullable = false)
	public String roleName;

	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	Set<User> users;


	@ManyToMany(targetEntity = Permission.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "role_permission", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "permission_id") })
	Set<Permission> permissions;

	public Set<Permission> getPermissions() {
		return this.permissions;
	}

	public void addPermission(Permission permission) {
		this.permissions.add(permission);
		permission.getRoles().add(this);
	}

	public void removePermission(Permission permission) {
		this.permissions.remove(permission);
		permission.getRoles().remove(this);
	}

	public Role(String roleName, Set<User> users, Set<Permission> permissions) {
		super();
		this.roleName = roleName;
		this.users = users;
		this.permissions = permissions;
	}



}
