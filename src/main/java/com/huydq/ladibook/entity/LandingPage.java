package com.huydq.ladibook.entity;

import java.sql.Date;
import java.util.HashSet;
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
import javax.persistence.JoinTable;
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
@Table(name = "ladingpage", indexes = { @Index(name = "user_id_index", columnList = "user_id"),
		@Index(name = "status_index", columnList = "status") })
public class LandingPage extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ladingpage_id", nullable = false, unique = true)
	private long ladingpageId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User creator;

	@Column(name = "source_url", nullable = false)
	private String sourceUrl;

	@Column(name = "thumbnail_url", nullable = false)
	private String thumbnailUrl;

	@Column(name = "view_count", nullable = false)
	private int viewCount = 0;

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "end_time")
	private Date endTime;

	@Column(name = "status")
	private String status; // actice, deactive

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ladingpage_form", joinColumns = { @JoinColumn(name = "ladingpage_id") }, inverseJoinColumns = {
			@JoinColumn(name = "form_id") })
	Set<Form> forms = new HashSet<>();

	public Set<Form> getforms() {
		return forms;
	}

	public void addForm(Form form) {
		forms.add(form);
		form.getLandingPages().add(this);
	}

	public void removeForm(Form form) {
		this.forms.remove(form);
		form.getLandingPages().remove(this);
	}

}
