package com.halehan.ct.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.PatientTask;

@XmlRootElement(name = "patientTask")
public class PatientTaskVo {

	private long patientTaskId;

	private long patientId;

	private long workflowId;

	private int workflowdetailId;

	private long studyId;

	private String taskNotes = "";

	private String taskStart = "";

	private String taskExpiration = "";

	private String taskComplete = "";

	private String taskStatus = "";

	private String taskName = "";

	private boolean finishTask = false;

	/* Derived */

	private String patientName = "";
	private String studyName = "";
	private String step = "";

	public PatientTaskVo() {

	}

	public void copyPatientTask(PatientTask patientTask) {

		this.patientId = patientTask.getPatient().getPatientId();
		this.patientTaskId = patientTask.getPatientTaskId();
		// this.workflowId = patientTask.getWorkflow().getWorkflowId();
		this.workflowdetailId = patientTask.getWorkflowDetail()
				.getWorkflowdetailId();
		this.taskNotes = this.padNull(patientTask.getTaskNotes());
		this.taskStart = toString(patientTask.getTaskStartDt());
		this.taskExpiration = toString(patientTask.getTaskExpireDt());
		this.taskComplete = toString(patientTask.getTaskCompleteDt());
		this.taskStatus = this.maskStatus(patientTask.getTaskStatus());
		// this.taskName = patientTask.getWorkflow().getName();
		this.taskName = patientTask.getWorkflowDetail().getWorkflowName();
		this.studyName = patientTask.getPatient().getStudy().getShortName();
		this.patientName = patientTask.getPatient().getFname() + " "
				+ patientTask.getPatient().getLname();
		this.studyId = patientTask.getPatient().getStudy().getStudyId();
		// this.step = patientTask.getWorkflow().getStep();
		this.step = patientTask.getWorkflowDetail().getWorkflowStep() + "";

	}

	public long getPatientTaskId() {
		return patientTaskId;
	}

	public void setPatientTaskId(long patientTaskId) {
		this.patientTaskId = patientTaskId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(long workflowId) {
		this.workflowId = workflowId;
	}

	public String getTaskNotes() {
		return taskNotes;
	}

	public void setTaskNotes(String taskNotes) {
		this.taskNotes = taskNotes;
	}

	public String getTaskStart() {
		return taskStart;
	}

	public void setTaskStart(String taskStart) {
		this.taskStart = taskStart;
	}

	public String getTaskExpiration() {
		return taskExpiration;
	}

	public void setTaskExpiration(String taskExpiration) {
		this.taskExpiration = taskExpiration;
	}

	public String getTaskComplete() {
		return taskComplete;
	}

	public void setTaskComplete(String taskComplete) {
		this.taskComplete = taskComplete;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	private String toString(Date date) {

		String rtnStringDate = "";

		if (!(date == null)) {

			String DATE_FORMAT = "MM/dd/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

			rtnStringDate = sdf.format(date);

		}

		return rtnStringDate;

	}

	private String padNull(String val) {

		String rtn = (val == null) ? "" : val;

		return rtn;

	}

	public String unMaskStatus(String status) {
		String maskStatus = "";

		if (status.equalsIgnoreCase("New"))
			maskStatus = "new";
		else if (status.equalsIgnoreCase("Expired"))
			maskStatus = "expired";
		else if (status.equalsIgnoreCase("Pending"))
			maskStatus = "pending";
		else if (status.equalsIgnoreCase("Complete"))
			maskStatus = "complete";

		return maskStatus;
	}

	private String maskStatus(String status) {
		String maskStatus = "";

		if (status.equalsIgnoreCase("new"))
			maskStatus = "New";
		else if (status.equalsIgnoreCase("expired"))
			maskStatus = "Expired";
		else if (status.equalsIgnoreCase("pending"))
			maskStatus = "Pending";
		else if (status.equalsIgnoreCase("complete"))
			maskStatus = "Complete";

		return maskStatus;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public boolean isFinishTask() {
		return finishTask;
	}

	public void setFinishTask(boolean finishTask) {
		this.finishTask = finishTask;
	}

	public long getStudyId() {
		return studyId;
	}

	public void setStudyId(long studyId) {
		this.studyId = studyId;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public int getWorkflowdetailId() {
		return workflowdetailId;
	}

	public void setWorkflowdetailId(int workflowdetailId) {
		this.workflowdetailId = workflowdetailId;
	}

}
