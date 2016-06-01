package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "party_type")
public class partyTypeModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int party_type_id;
	private int deed_type_id;
	private String part_name;
	private String remarks;
	private int created_by;
	private Date created_datetime;
	private int updated_by;
	private Date updated_date;
	private int lang_id;

	@Id
	@Column(name = "party_type_id")
	@SequenceGenerator(name = "party_type_seq", sequenceName = "party_type_party_type_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_type_seq")
	public int getParty_type_id() {
		return party_type_id;
	}

	public void setParty_type_id(int party_type_id) {
		this.party_type_id = party_type_id;
	}

	@Column(name = "deed_type_id")
	public int getDeed_type_id() {
		return deed_type_id;
	}

	public void setDeed_type_id(int deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	@Column(name = "party_name")
	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
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
	
	
	@Column(name = "lang_id")
	public int getLang_id() {
		return lang_id;
	}

	public void setLang_id(int lang_id) {
		this.lang_id = lang_id;
	}

}