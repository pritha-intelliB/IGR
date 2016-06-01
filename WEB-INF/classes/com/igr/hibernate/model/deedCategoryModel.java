package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "deed_category")
public class deedCategoryModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int deed_category_id;
	private int deed_type_id;
	private String category_name;
	private float stamp_fee;
	private String stamp_unit;
	private int created_by;
	private Date created_datetime;
	private int updated_by;
	private Date updated_datetime;
	private int lang_id;
	
	
	
	@Id
	@Column(name = "deed_category_id")
	@SequenceGenerator(name = "deed_category_seq", sequenceName = "deed_category_deed_category_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deed_category_seq")
	public int getDeed_category_id() {
		return deed_category_id;
	}
	public void setDeed_category_id(int deed_category_id) {
		this.deed_category_id = deed_category_id;
	}
	
	@Column(name = "deed_type_id")
	public int getDeed_type_id() {
		return deed_type_id;
	}
	public void setDeed_type_id(int deed_type_id) {
		this.deed_type_id = deed_type_id;
	}
	
	@Column(name = "category_name")
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	@Column(name = "stamp_fee")
	public float getStamp_fee() {
		return stamp_fee;
	}
	public void setStamp_fee(float stamp_fee) {
		this.stamp_fee = stamp_fee;
	}
	
	@Column(name = "stamp_unit")
	public String getStamp_unit() {
		return stamp_unit;
	}
	public void setStamp_unit(String stamp_unit) {
		this.stamp_unit = stamp_unit;
	}
	
	@Column(name = "created_by")
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	@Column(name = "created_datetime")
	public Date getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}
	@Column(name = "updated_by")
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	@Column(name = "updated_datetime")
	public Date getUpdated_datetime() {
		return updated_datetime;
	}
	public void setUpdated_datetime(Date updated_datetime) {
		this.updated_datetime = updated_datetime;
	}
	
	@Column(name = "lang_id")
	public int getLang_id() {
		return lang_id;
	}
	public void setLang_id(int lang_id) {
		this.lang_id = lang_id;
	}
	
	
	
	
	
	
}