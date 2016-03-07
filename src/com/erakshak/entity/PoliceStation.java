package com.erakshak.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the police_station database table.
 * 
 */
@Entity
@Table(name="police_station")
@NamedQuery(name="PoliceStation.findAll", query="SELECT p FROM PoliceStation p")
public class PoliceStation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="email_id")
	private String emailId;

	private String location;

	@Column(name="mobile_number")
	private Integer mobileNumber;

	private String name;

	private String type;

	//bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy="policeStation")
	private List<Complaint> complaints;

	//bi-directional many-to-one association to Officer
	@OneToMany(mappedBy="policeStation")
	private List<Officer> officers;

	//bi-directional many-to-one association to Commisionerate
	@ManyToOne
	private Commisionerate commisionerate;

	public PoliceStation() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Complaint> getComplaints() {
		return this.complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Complaint addComplaint(Complaint complaint) {
		getComplaints().add(complaint);
		complaint.setPoliceStation(this);

		return complaint;
	}

	public Complaint removeComplaint(Complaint complaint) {
		getComplaints().remove(complaint);
		complaint.setPoliceStation(null);

		return complaint;
	}

	public List<Officer> getOfficers() {
		return this.officers;
	}

	public void setOfficers(List<Officer> officers) {
		this.officers = officers;
	}

	public Officer addOfficer(Officer officer) {
		getOfficers().add(officer);
		officer.setPoliceStation(this);

		return officer;
	}

	public Officer removeOfficer(Officer officer) {
		getOfficers().remove(officer);
		officer.setPoliceStation(null);

		return officer;
	}

	public Commisionerate getCommisionerate() {
		return this.commisionerate;
	}

	public void setCommisionerate(Commisionerate commisionerate) {
		this.commisionerate = commisionerate;
	}

}