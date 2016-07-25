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
 * The persistent class for the patient_task_history database table.
 * 
 */
@Entity
@Table(name = "patient_task_history")
@NamedQuery(name = "PatientTaskHistory.findAll", query = "SELECT p FROM PatientTaskHistory p")
public class PatientTaskHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpatient_task_history")
	private int idpatientTaskHistory;

	private String note;

	@Column(name = "update_time")
	private Timestamp updateTime;

	// bi-directional many-to-one association to PatientTask
	@ManyToOne
	@JoinColumn(name = "patientTaskId")
	private PatientTask patientTask;

	public PatientTaskHistory() {
	}

	public int getIdpatientTaskHistory() {
		return this.idpatientTaskHistory;
	}

	public void setIdpatientTaskHistory(int idpatientTaskHistory) {
		this.idpatientTaskHistory = idpatientTaskHistory;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public PatientTask getPatientTask() {
		return this.patientTask;
	}

	public void setPatientTask(PatientTask patientTask) {
		this.patientTask = patientTask;
	}

}