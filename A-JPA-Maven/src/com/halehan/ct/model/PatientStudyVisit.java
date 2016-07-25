package com.halehan.ct.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the patient_study_visit database table.
 * 
 */
@Entity
@Table(name = "patient_study_visit")
@NamedQuery(name = "PatientStudyVisit.findAll", query = "SELECT p FROM PatientStudyVisit p")
public class PatientStudyVisit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpatient_study_visit")
	private int idpatientStudyVisit;

	private Timestamp visitDate;

	// bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;

	// bi-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name = "siteId")
	private Site site;

	// bi-directional many-to-one association to Workflow
	@ManyToOne
	@JoinColumn(name = "workflowId")
	private Workflow workflow;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "doctorId")
	private User doctor;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "staffId")
	private User staff;

	public PatientStudyVisit() {
	}

	public int getIdpatientStudyVisit() {
		return this.idpatientStudyVisit;
	}

	public void setIdpatientStudyVisit(int idpatientStudyVisit) {
		this.idpatientStudyVisit = idpatientStudyVisit;
	}

	public Timestamp getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Timestamp visitDate) {
		this.visitDate = visitDate;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public User getStaff() {
		return staff;
	}

	public void setStaff(User staff) {
		this.staff = staff;
	}

}