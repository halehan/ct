package com.halehan.ct.vo;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.PatientTask;
import com.halehan.ct.model.Workflow;

@XmlRootElement(name = "workflow")
public class WorkflowVo {

	private long workflowId;
	private long expireDuration;
	private String name;
	private String step;
	private Date updateDt;
	private List<PatientTask> patientTasks;

	public void copyStudy(Workflow workflow) {
		this.workflowId = workflow.getWorkflowId();
		this.expireDuration = workflow.getExpireDuration();
		this.name = workflow.getName();
		this.step = workflow.getStep();
		this.updateDt = workflow.getUpdateDt();
		this.patientTasks = workflow.getPatientTasks();

	}

	public long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(long workflowId) {
		this.workflowId = workflowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public List<PatientTask> getPatientTasks() {
		return patientTasks;
	}

	public void setPatientTasks(List<PatientTask> patientTasks) {
		this.patientTasks = patientTasks;
	}

	public long getExpireDuration() {
		return expireDuration;
	}

	public void setExpireDuration(long expireDuration) {
		this.expireDuration = expireDuration;
	}

}
