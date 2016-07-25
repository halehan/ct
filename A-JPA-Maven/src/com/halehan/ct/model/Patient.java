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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.Cache;

/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@Cache(size = 12000, expiry = 5000)
@Table(name = "patient", schema = "ct")

@NamedQueries({
		@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
		@NamedQuery(name = "Patient.findExpired", query = "SELECT p FROM Patient p, PatientTask t WHERE p.patientTasks = t and t.taskStatus = 'expired'"),
		@NamedQuery(name = "Patient.findPending", query = "SELECT p FROM Patient p, PatientTask t WHERE p.patientTasks = t and t.taskStatus = 'pending'"),
		@NamedQuery(name = "Patient.findByStudy", query = "SELECT p FROM Patient p WHERE p.study.studyId = :studyId"),
		@NamedQuery(name = "Patient.findEnrolled", query = "SELECT p FROM Patient p WHERE p.status = 'enrolled'"),
		@NamedQuery(name = "Patient.findNew", query = "SELECT p FROM Patient p, PatientTask t WHERE p.patientTasks = t and t.taskStatus = 'new'")})
@XmlRootElement(name = "patient")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private String fname;

	private String lname;

	private String mi;

	private String phone;

	// private int study;

	private String studyeye;

	private String status;

	@Temporal(TemporalType.DATE)
	private Date initialcontactdate;

	// bi-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name = "siteId")
	private Site site;

	// bi-directional many-to-one association to Study
	@ManyToOne
	@JoinColumn(name = "study")
	private Study study;

	// bi-directional many-to-one association to PatientTask
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@OrderBy("patientTaskId DESC")
	private List<PatientTask> patientTasks;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "technician")
	private User technician;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "doctor")
	private User doctor;

	public Patient() {
	}

	public long getPatientId() {
		return this.patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMi() {
		return this.mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStudyeye() {
		return this.studyeye;
	}

	public void setStudyeye(String studyeye) {
		this.studyeye = studyeye;
	}

	public List<PatientTask> getPatientTasks() {
		return this.patientTasks;
	}

	public void setPatientTasks(List<PatientTask> patientTasks) {
		this.patientTasks = patientTasks;
	}

	public PatientTask addPatientTask(PatientTask patientTask) {
		getPatientTasks().add(patientTask);
		patientTask.setPatient(this);

		return patientTask;
	}

	public PatientTask removePatientTask(PatientTask patientTask) {
		getPatientTasks().remove(patientTask);
		patientTask.setPatient(null);

		return patientTask;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public Study getStudy() {
		return study;
	}

	public Date getInitialcontactdate() {
		return initialcontactdate;
	}

	public void setInitialcontactdate(Date initialcontactdate) {
		this.initialcontactdate = initialcontactdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public User getTechnician() {
		return technician;
	}

	public void setTechnician(User technician) {
		this.technician = technician;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

}