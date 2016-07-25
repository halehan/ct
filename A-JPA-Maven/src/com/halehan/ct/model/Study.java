package com.halehan.ct.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Cache;

/**
 * The persistent class for the study database table.
 * 
 */
@Entity
@Cache(size = 12000, expiry = 5000)
@Table(name = "study", schema = "ct")
@NamedQuery(name = "Study.findAll", query = "SELECT s FROM Study s")
public class Study implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studyId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "study_description")
	private String studyDescription;

	@Column(name = "drug_name")
	private String drugName;

	@Column(name = "study_identifier")
	private String studyIdentifier;

	@Column(name = "poc_email")
	private String pocEmail;

	@Column(name = "poc_name")
	private String pocName;

	@Column(name = "poc_phone")
	private String pocPhone;

	@Column(name = "study_enrollment_goal")
	private int studyEnrollmentGoal;

	@Column(name = "study_name")
	private String studyName;

	@Column(name = "short_name")
	private String shortName;

	@Column(name = "update_dt")
	@Temporal(TemporalType.DATE)
	private Date updateDt;

	@Column(name = "start_dt")
	@Temporal(TemporalType.DATE)
	private Date startDt;

	@Column(name = "end_dt")
	@Temporal(TemporalType.DATE)
	private Date endDt;

	// bi-directional many-to-one association to Patient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
	private List<Patient> patients;

	// bi-directional many-to-one association to SiteStudyAssoc
	@OneToMany(mappedBy = "study")
	private List<SiteStudyAssoc> siteStudyAssocs;

	// bi-directional many-to-one association to StudyDeviation
	@OneToMany(mappedBy = "study")
	private List<StudyDeviation> studyDeviations;

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
	 * 
	 * @OrderBy("step ASC") private List<Workflow> worfkflows;
	 */
	public Study() {
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPocEmail() {
		return this.pocEmail;
	}

	public void setPocEmail(String pocEmail) {
		this.pocEmail = pocEmail;
	}

	public String getPocName() {
		return this.pocName;
	}

	public void setPocName(String pocName) {
		this.pocName = pocName;
	}

	public String getPocPhone() {
		return this.pocPhone;
	}

	public void setPocPhone(String pocPhone) {
		this.pocPhone = pocPhone;
	}

	public int getStudyEnrollmentGoal() {
		return this.studyEnrollmentGoal;
	}

	public void setStudyEnrollmentGoal(int studyEnrollmentGoal) {
		this.studyEnrollmentGoal = studyEnrollmentGoal;
	}

	public String getStudyName() {
		return this.studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getStudyIdentifier() {
		return studyIdentifier;
	}

	public void setStudyIdentifier(String studyIdentifier) {
		this.studyIdentifier = studyIdentifier;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/*
	 * public List<Workflow> getWorfkflows() { return worfkflows; }
	 * 
	 * public void setWorfkflows(List<Workflow> worfkflows) { this.worfkflows =
	 * worfkflows; }
	 */
	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public String getStudyDescription() {
		return studyDescription;
	}

	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}

	public List<SiteStudyAssoc> getSiteStudyAssocs() {
		return siteStudyAssocs;
	}

	public void setSiteStudyAssocs(List<SiteStudyAssoc> siteStudyAssocs) {
		this.siteStudyAssocs = siteStudyAssocs;
	}

	public List<StudyDeviation> getStudyDeviations() {
		return studyDeviations;
	}

	public void setStudyDeviations(List<StudyDeviation> studyDeviations) {
		this.studyDeviations = studyDeviations;
	}

}