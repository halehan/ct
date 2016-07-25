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
 * The persistent class for the patient_task database table.
 * 
 */
@Entity
@Table(name = "patient_task", schema = "ct")
@NamedQueries({
		@NamedQuery(name = "PatientTask.findAll", query = "SELECT p FROM PatientTask p"),
		@NamedQuery(name = "PatientTask.findByPatient", query = "SELECT p FROM PatientTask p where p.patient.patientId = :patientId")})

public class PatientTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6634034371696943014L;

	@Id
	private long patientTaskId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "task_complete_dt")
	private Date taskCompleteDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "task_expire_dt")
	private Date taskExpireDt;

	@Column(name = "task_notes")
	private String taskNotes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "task_start_dt")
	private Date taskStartDt;

	@Column(name = "task_status")
	private String taskStatus;

	// bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;

	// bi-directional many-to-one association to Workflow
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workflowdetailId")
	private WorkflowDetail workflowDetail;

	// bi-directional many-to-one association to Workflow
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workflowId")
	private Workflow workflow;

	// bi-directional many-to-one association to PatientTaskHistory
	@OneToMany(mappedBy = "patientTask")
	private List<PatientTaskHistory> patientTaskHistories;

	public PatientTask() {
	}

	public long getPatientTaskId() {
		return this.patientTaskId;
	}

	public void setPatientTaskId(long patientTaskId) {
		this.patientTaskId = patientTaskId;
	}

	public Date getTaskCompleteDt() {
		return this.taskCompleteDt;
	}

	public void setTaskCompleteDt(Date taskCompleteDt) {
		this.taskCompleteDt = taskCompleteDt;
	}

	public Date getTaskExpireDt() {
		return this.taskExpireDt;
	}

	public void setTaskExpireDt(Date taskExpireDt) {
		this.taskExpireDt = taskExpireDt;
	}

	public String getTaskNotes() {
		return this.taskNotes;
	}

	public void setTaskNotes(String taskNotes) {
		this.taskNotes = taskNotes;
	}

	public Date getTaskStartDt() {
		return this.taskStartDt;
	}

	public void setTaskStartDt(Date taskStartDt) {
		this.taskStartDt = taskStartDt;
	}

	public String getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public List<PatientTaskHistory> getPatientTaskHistories() {
		return patientTaskHistories;
	}

	public void setPatientTaskHistories(
			List<PatientTaskHistory> patientTaskHistories) {
		this.patientTaskHistories = patientTaskHistories;
	}

	public WorkflowDetail getWorkflowDetail() {
		return workflowDetail;
	}

	public void setWorkflowDetail(WorkflowDetail workflowDetail) {
		this.workflowDetail = workflowDetail;
	}

}