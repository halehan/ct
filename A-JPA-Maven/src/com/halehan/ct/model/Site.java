package com.halehan.ct.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * The persistent class for the site database table.
 * 
 */
@Entity
@NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int siteId;

	@Column(name = "abbreviated_name")
	private String abbreviatedName;

	private String address;

	private String city;

	private String name;

	private String phone;

	private int practiceId;

	private String state;

	private String zip;

	// bi-directional many-to-one association to Patient
	@OneToMany(mappedBy = "site")
	@JoinColumn(name = "siteId", insertable = false, updatable = false)
	private List<Patient> patients;

	// bi-directional many-to-one association to Practice
	@ManyToOne
	@JoinColumn(name = "practiceId", insertable = false, updatable = false)
	private Practice practice;

	// bi-directional many-to-one association to SiteStudyAssoc
	@OneToMany(mappedBy = "site")
	@JoinColumn(name = "siteId", insertable = false, updatable = false)
	private List<SiteStudyAssoc> siteStudyAssocs;

	// bi-directional many-to-one association to StudyDeviation
	@OneToMany(mappedBy = "site")
	private List<StudyDeviation> studyDeviations;

	// bi-directional many-to-one association to SiteEquipment
	@OneToMany(mappedBy = "site")
	@JoinColumn(name = "siteId", insertable = false, updatable = false)
	private List<SiteEquipment> siteEquipments;

	// bi-directional many-to-one association to Users
	@OneToMany(mappedBy = "site")
	@JoinColumn(name = "siteId", insertable = false, updatable = false)
	@OrderBy("role DESC")
	private List<User> users;

	public Site() {
	}

	public int getSiteId() {
		return this.siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getAbbreviatedName() {
		return this.abbreviatedName;
	}

	public void setAbbreviatedName(String abbreviatedName) {
		this.abbreviatedName = abbreviatedName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPracticeId() {
		return this.practiceId;
	}

	public void setPracticeId(int practiceId) {
		this.practiceId = practiceId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<StudyDeviation> getStudyDeviations() {
		return this.studyDeviations;
	}

	public void setStudyDeviations(List<StudyDeviation> studyDeviations) {
		this.studyDeviations = studyDeviations;
	}

	public StudyDeviation addStudyDeviation(StudyDeviation studyDeviation) {
		getStudyDeviations().add(studyDeviation);
		studyDeviation.setSite(this);

		return studyDeviation;
	}

	public StudyDeviation removeStudyDeviation(StudyDeviation studyDeviation) {
		getStudyDeviations().remove(studyDeviation);
		studyDeviation.setSite(null);

		return studyDeviation;
	}

	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	public List<SiteStudyAssoc> getSiteStudyAssocs() {
		return siteStudyAssocs;
	}

	public void setSiteStudyAssocs(List<SiteStudyAssoc> siteStudyAssocs) {
		this.siteStudyAssocs = siteStudyAssocs;
	}

	public List<SiteEquipment> getSiteEquipments() {
		return siteEquipments;
	}

	public void setSiteEquipments(List<SiteEquipment> siteEquipments) {
		this.siteEquipments = siteEquipments;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}