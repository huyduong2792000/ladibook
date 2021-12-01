package com.huydq.ladibook.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sale")
public class Sale extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_id", nullable = false, unique = true)
	private String saleId;

	@Column(name = "sale_percent")
	private int salePercent;

	@Column(name = "sale_value")
	private int saleValue;

	@OneToMany(mappedBy = "sale")
	private List<Product> products;

}
