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
@Table(name = "landingpage", indexes = { @Index(name = "user_id_index", columnList = "user_id"),
		@Index(name = "status_index", columnList = "status") })
public class LandingPage extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "landingpage_id", nullable = false, unique = true)
	private long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User creator;

	@Column(name = "source_url")
	private String sourceUrl;

	@Column(name = "template_no")
	private String templateNo;

	@Column(name = "thumbnail_url", nullable = false) // url thumbnail của ladingpage sẽ hiển thị sau khi tạo
	private String thumbnailUrl = "https://mondaycareer.com/wp-content/uploads/2020/12/Landing-Page-l%C3%A0-g%C3%AC.png";

	@Column(name = "view_count", nullable = false)
	private int viewCount = 0;

	@Column(name = "order_count", nullable = false)
	private int orderCount = 0;

	@Column(name = "order_percent", nullable = false)
	private String orderPercent = "0.0";

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "end_time")
	private Date endTime;

	@Column(name = "ladingpage_name", nullable = false)
	private String landingPageName;

	@Column(name = "domain")
	private String domain = "http://localhost:8080/ladibook/landingpage/" + id;

	@Column(name = "status", nullable = false)
	private String status; // actice, deactive, created

	@Column(name = "price")
	private float price = 0;

	@Column(name = "price_label")
	private String priceLabel;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "landingpage_form", joinColumns = { @JoinColumn(name = "landingpage_id") }, inverseJoinColumns = {
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
