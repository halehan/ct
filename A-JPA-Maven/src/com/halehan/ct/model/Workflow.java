package com.halehan.ct.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the workflow database table.
 * 
 */
@Entity
@Table(name = "workflow", schema = "ct")
@NamedQueries({
		@NamedQuery(name = "Workflow.findAll", query = "SELECT w FROM Workflow w"),
		@NamedQuery(name = "Workflow.findByStudy", query = "SELECT w FROM Workflow w WHERE w.step = :step")})
public class Workflow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5071146619923313137L;

	@Id
	private long workflowId;

	@Column(name = "expire_duration")
	private int expireDuration;

	private String name;

	private String step;

	private int studyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_dt")
	private Date updateDt;

	// bi-directional many-to-one association to PatientTask
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "workflow")
	private List<PatientTask> patientTasks;

	// bi-directional many-to-one association to study
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "studyId", updatable = false, insertable = false)
	private Study study;

	public Workflow() {
	}

	public long getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(long workflowId) {
		this.workflowId = workflowId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStep() {
		return this.step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public List<PatientTask> getPatientTasks() {
		return this.patientTasks;
	}

	public void setPatientTasks(List<PatientTask> patientTasks) {
		this.patientTasks = patientTasks;
	}

	public PatientTask addPatientTask(PatientTask patientTask) {
		getPatientTasks().add(patientTask);
		patientTask.setWorkflow(this);

		return patientTask;
	}

	public PatientTask removePatientTask(PatientTask patientTask) {
		getPatientTasks().remove(patientTask);
		patientTask.setWorkflow(null);

		return patientTask;
	}

	public int getExpireDuration() {
		return expireDuration;
	}

	public void setExpireDuration(int expireDuration) {
		this.expireDuration = expireDuration;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

}