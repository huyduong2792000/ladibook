package com.huydq.ladibook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public abstract class Base {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private long id;
//
//	@Version
//	private Integer version;

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	public Date createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	public Date updatedAt;
	
	@PrePersist
	public void prePersist() {
		if (this.createdAt == null)
			createdAt = new Date();
		if (this.updatedAt == null)
			updatedAt = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedAt = new Date();
	}

	@PreRemove
	public void preRemove() {
		this.updatedAt = new Date();
	}

}
