package com.halehan.ct.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the site database table.
 * 
 */
@Entity
@Table(name = "site_counts", schema = "ct")
@NamedQuery(name = "SiteCounts.findAll", query = "SELECT s FROM SiteCounts s")
public class SiteCounts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2252151292873106580L;

	@Id
	private int patientId;

	private int practiceId;

	private String study_name;

	private String site_name;

	private String doctor;

	private String patient_status;

	private int studyId;

	private int siteId;

	public String getStudy_name() {
		return study_name;
	}

	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPatient_status() {
		return patient_status;
	}

	public void setPatient_status(String patient_status) {
		this.patient_status = patient_status;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(int practiceId) {
		this.practiceId = practiceId;
	}

}