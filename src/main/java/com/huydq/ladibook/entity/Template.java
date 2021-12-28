package com.huydq.ladibook.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "template")
@Setter
@Getter
public class Template extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "template_id", nullable = false, unique = true)
	private long id;

	@Column(name = "template_name")
	private String templateName;

	@Column(name = "template_no")
	private String templateNo;

	@Column(name = "thumbnail")
	private String thumbnail;

	@Column(name = "template_type") // FREE, PREMIUM
	private String templateType;

}
