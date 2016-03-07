package com.erakshak.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the commisionerate database table.
 * 
 */
@Entity
@NamedQuery(name="Commisionerate.findAll", query="SELECT c FROM Commisionerate c")
public class Commisionerate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="email_id")
	private String emailId;

	private String location;

	@Column(name="mobile_number")
	private Integer mobileNumber;

	private String name;

	//bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy="commisionerate")
	private List<Complaint> complaints;

	//bi-directional many-to-one association to PoliceStation
	@OneToMany(mappedBy="commisionerate")
	private List<PoliceStation> policeStations;

	public Commisionerate() {
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

	public List<Complaint> getComplaints() {
		return this.complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Complaint addComplaint(Complaint complaint) {
		getComplaints().add(complaint);
		complaint.setCommisionerate(this);

		return complaint;
	}

	public Complaint removeComplaint(Complaint complaint) {
		getComplaints().remove(complaint);
		complaint.setCommisionerate(null);

		return complaint;
	}

	public List<PoliceStation> getPoliceStations() {
		return this.policeStations;
	}

	public void setPoliceStations(List<PoliceStation> policeStations) {
		this.policeStations = policeStations;
	}

	public PoliceStation addPoliceStation(PoliceStation policeStation) {
		getPoliceStations().add(policeStation);
		policeStation.setCommisionerate(this);

		return policeStation;
	}

	public PoliceStation removePoliceStation(PoliceStation policeStation) {
		getPoliceStations().remove(policeStation);
		policeStation.setCommisionerate(null);

		return policeStation;
	}

}