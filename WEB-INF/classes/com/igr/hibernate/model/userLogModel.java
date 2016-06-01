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
@Table(name = "user_log")
public class userLogModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int user_log_id;
	private int user_id;
	private String user_action;
	private String user_log_comment;
	private Date log_datetime;
	
	@Id
	@Column(name = "user_log_id")
	@SequenceGenerator(name="user_log_id_seq", sequenceName="user_log_user_log_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_log_id_seq")
	public int getUser_log_id() {
		return user_log_id;
	}

	public void setUser_log_id(int user_log_id) {
		this.user_log_id = user_log_id;
	}

	@Column(name = "user_id")
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Column(name = "user_action")
	public String getUser_action() {
		return user_action;
	}

	public void setUser_action(String user_action) {
		this.user_action = user_action;
	}

	@Column(name = "user_log_comment")
	public String getUser_log_comment() {
		return user_log_comment;
	}

	public void setUser_log_comment(String user_log_comment) {
		this.user_log_comment = user_log_comment;
	}


	@Column(name = "log_datetime")
	public Date getLog_datetime() {
		return log_datetime;
	}

	public void setLog_datetime(Date log_datetime) {
		this.log_datetime = log_datetime;
	}

	

}