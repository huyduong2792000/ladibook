package com.huydq.ladibook.entity;


import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "price")
public class Price extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_id", nullable = false, unique = true)
	private long priceId;

	@Column(name = "price_name")
	private String priceName;

	@Column(name = "is_default")
	private boolean isDefault;

	@Column(name = "price_unit")
	private String priceUnit;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "end_time")
	private Date endTime;

	@OneToMany(mappedBy = "price", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<ProductPrice> productPrices;

}
