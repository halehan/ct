package com.halehan.ct.vo.charts;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patientTaskList")
public class PatientStudyTaskVo {

	private int patientTaskId;
	private String patientName;
	private int patientId;
	private String studyName;
	private String notes;
	private String status;
	private String workflowName;
	private String startDt;
	private String finishDt;

	public String getStudyName() {
		return studyName;
	}
	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public String getFinishDt() {
		return finishDt;
	}
	public void setFinishDt(String finishDt) {
		this.finishDt = finishDt;
	}
	public int getPatientTaskId() {
		return patientTaskId;
	}
	public void setPatientTaskId(int patientTaskId) {
		this.patientTaskId = patientTaskId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
