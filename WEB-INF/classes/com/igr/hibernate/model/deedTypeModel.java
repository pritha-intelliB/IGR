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
@Table(name = "deed_type")
public class deedTypeModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int deed_type_id;
	private String deed_name;
	private String deed_code;
	private String remarks;
	private int created_by;
	private Date created_datetime;
	private int updated_by;
	private Date updated_date;
	private boolean property_details;
	private int book_id;
	private int lang_id;
	
	

	@Id
	@Column(name = "deed_type_id")
	@SequenceGenerator(name = "deed_type_seq", sequenceName = "deed_type_deed_type_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deed_type_seq")
	public int getDeed_type_id() {
		return deed_type_id;
	}

	public void setDeed_type_id(int deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	@Column(name = "deed_name")
	public String getDeed_name() {
		return deed_name;
	}

	public void setDeed_name(String deed_name) {
		this.deed_name = deed_name;
	}

	@Column(name = "deed_code")
	public String getDeed_code() {
		return deed_code;
	}

	public void setDeed_code(String deed_code) {
		this.deed_code = deed_code;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "created_by")
	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	@Column(name = "created_date")
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

	@Column(name = "updated_date")
	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	@Column(name = "property_details")
	public boolean isProperty_details() {
		return property_details;
	}

	public void setProperty_details(boolean property_details) {
		this.property_details = property_details;
	}

	@Column(name = "book_id")
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	@Column(name = "lang_id")
	public int getLang_id() {
		return lang_id;
	}

	public void setLang_id(int lang_id) {
		this.lang_id = lang_id;
	}
	
	
}