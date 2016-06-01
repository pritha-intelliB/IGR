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
@Table(name = "fee_structure")
public class feeStructureModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int fee_id;
	private int deed_category_id;
	private String fee_name;
	private float fee_val;
	private String fee_unit;
	private String depends_on;
	private int created_by;
	private Date created_datetime;
	private int updated_by;
	private Date updated_date;
	private int lang_id;

	@Id
	@Column(name = "fee_id")
	@SequenceGenerator(name = "fee_structure_seq", sequenceName = "fee_structure_fee_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_structure_seq")
	public int getFee_id() {
		return fee_id;
	}

	public void setFee_id(int fee_id) {
		this.fee_id = fee_id;
	}

	@Column(name = "deed_category_id")
	public int getDeed_category_id() {
		return deed_category_id;
	}

	public void setDeed_category_id(int deed_category_id) {
		this.deed_category_id = deed_category_id;
	}

	@Column(name = "fee_name")
	public String getFee_name() {
		return fee_name;
	}

	public void setFee_name(String fee_name) {
		this.fee_name = fee_name;
	}

	@Column(name = "fee_val")
	public float getFee_val() {
		return fee_val;
	}

	public void setFee_val(float fee_val) {
		this.fee_val = fee_val;
	}

	@Column(name = "fee_unit")
	public String getFee_unit() {
		return fee_unit;
	}

	public void setFee_unit(String fee_unit) {
		this.fee_unit = fee_unit;
	}

	@Column(name = "depends_on")
	public String getDepends_on() {
		return depends_on;
	}

	public void setDepends_on(String depends_on) {
		this.depends_on = depends_on;
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
	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	
	
	@Column(name = "created_by")
	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	
	@Column(name = "lang_id")
	public int getLang_id() {
		return lang_id;
	}

	public void setLang_id(int lang_id) {
		this.lang_id = lang_id;
	}
	
	
	
	
	

}