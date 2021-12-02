package com.huydq.ladibook.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "form", indexes = { @Index(name = "product_id_index", columnList = "product_id"),
		@Index(name = "user_id_index", columnList = "user_id"),
		@Index(name = "form_type_index", columnList = "form_type") })
public class Form extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "form_id", nullable = false, unique = true)
	private long formId;

	@Column(name = "form_type", nullable = false) // sale, product
	private String formType;

	@Column(name = "form_name", nullable = false)
	private String formName;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User creator;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToMany(mappedBy = "forms", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<LandingPage> landingPages;

	public Set<LandingPage> getLandingPages() {
		return landingPages;
	}

}
