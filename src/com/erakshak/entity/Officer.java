package com.erakshak.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the officer database table.
 * 
 */
@Entity
@NamedQuery(name="Officer.findAll", query="SELECT o FROM Officer o")
public class Officer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String designation;

	@Column(name="email_id")
	private String emailId;

	@Column(name="mobile_number")
	private Integer mobileNumber;

	private String name;

	private String password;

	//bi-directional many-to-one association to PoliceStation
	@ManyToOne
	@JoinColumn(name="police_station_id")
	private PoliceStation policeStation;

	public Officer() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PoliceStation getPoliceStation() {
		return this.policeStation;
	}

	public void setPoliceStation(PoliceStation policeStation) {
		this.policeStation = policeStation;
	}

}