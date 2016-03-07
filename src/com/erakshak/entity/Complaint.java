package com.erakshak.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the complaint database table.
 * 
 */
@Entity
@NamedQuery(name="Complaint.findAll", query="SELECT c FROM Complaint c")
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="applicant_address")
	private String applicantAddress;

	@Column(name="applicant_email_id")
	private String applicantEmailId;

	@Column(name="applicant_mobile_number")
	private Integer applicantMobileNumber;

	@Column(name="applicant_name")
	private String applicantName;

	private String description;

	@Column(name="is_public")
	private byte isPublic;

	@Column(name="newsroom_classifier")
	private String newsroomClassifier;

	@Column(name="officer_id")
	private Integer officerId;

	@Column(name="officers_attatcments")
	private String officersAttatcments;

	@Column(name="officers_description")
	private String officersDescription;

	@Column(name="officers_subject")
	private String officersSubject;

	@Column(name="proof_audios")
	private String proofAudios;

	@Column(name="proof_documents")
	private String proofDocuments;

	@Column(name="proof_images")
	private String proofImages;

	@Column(name="proof_videos")
	private String proofVideos;

	private String status;

	private String subject;

	@Column(name="tracking_id")
	private String trackingId;

	private String type;

	//bi-directional many-to-one association to Commisionerate
	@ManyToOne
	private Commisionerate commisionerate;

	//bi-directional many-to-one association to PoliceStation
	@ManyToOne
	@JoinColumn(name="police_station_id")
	private PoliceStation policeStation;

	public Complaint() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApplicantAddress() {
		return this.applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}

	public String getApplicantEmailId() {
		return this.applicantEmailId;
	}

	public void setApplicantEmailId(String applicantEmailId) {
		this.applicantEmailId = applicantEmailId;
	}

	public Integer getApplicantMobileNumber() {
		return this.applicantMobileNumber;
	}

	public void setApplicantMobileNumber(Integer applicantMobileNumber) {
		this.applicantMobileNumber = applicantMobileNumber;
	}

	public String getApplicantName() {
		return this.applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(byte isPublic) {
		this.isPublic = isPublic;
	}

	public String getNewsroomClassifier() {
		return this.newsroomClassifier;
	}

	public void setNewsroomClassifier(String newsroomClassifier) {
		this.newsroomClassifier = newsroomClassifier;
	}

	public Integer getOfficerId() {
		return this.officerId;
	}

	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
	}

	public String getOfficersAttatcments() {
		return this.officersAttatcments;
	}

	public void setOfficersAttatcments(String officersAttatcments) {
		this.officersAttatcments = officersAttatcments;
	}

	public String getOfficersDescription() {
		return this.officersDescription;
	}

	public void setOfficersDescription(String officersDescription) {
		this.officersDescription = officersDescription;
	}

	public String getOfficersSubject() {
		return this.officersSubject;
	}

	public void setOfficersSubject(String officersSubject) {
		this.officersSubject = officersSubject;
	}

	public String getProofAudios() {
		return this.proofAudios;
	}

	public void setProofAudios(String proofAudios) {
		this.proofAudios = proofAudios;
	}

	public String getProofDocuments() {
		return this.proofDocuments;
	}

	public void setProofDocuments(String proofDocuments) {
		this.proofDocuments = proofDocuments;
	}

	public String getProofImages() {
		return this.proofImages;
	}

	public void setProofImages(String proofImages) {
		this.proofImages = proofImages;
	}

	public String getProofVideos() {
		return this.proofVideos;
	}

	public void setProofVideos(String proofVideos) {
		this.proofVideos = proofVideos;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTrackingId() {
		return this.trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Commisionerate getCommisionerate() {
		return this.commisionerate;
	}

	public void setCommisionerate(Commisionerate commisionerate) {
		this.commisionerate = commisionerate;
	}

	public PoliceStation getPoliceStation() {
		return this.policeStation;
	}

	public void setPoliceStation(PoliceStation policeStation) {
		this.policeStation = policeStation;
	}

}