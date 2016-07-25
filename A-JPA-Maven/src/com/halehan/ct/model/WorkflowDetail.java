package com.halehan.ct.model;

import java.io.Serializable;

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
 * The persistent class for the workflow_details database table.
 * 
 */
@Entity
@Table(name = "workflow_details", schema = "ct")
@NamedQuery(name = "WorkflowDetail.findAll", query = "SELECT w FROM WorkflowDetail w")
public class WorkflowDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8521243023828326553L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "workflow_detailId")
	private int workflowdetailId;

	@Column(name = "workflow_name")
	private String workflowName;

	@Column(name = "workflow_step")
	private int workflowStep;

	@Column(name = "workflow_expire_days")
	private int workflowExpireDays;

	// bi-directional many-to-one association to WorkflowDefinition
	@ManyToOne
	@JoinColumn(name = "workflow_definitionId")
	private WorkflowDefinition workflowDefinition;

	public WorkflowDetail() {
	}

	public String getWorkflowName() {
		return this.workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public int getWorkflowStep() {
		return this.workflowStep;
	}

	public void setWorkflowStep(int workflowStep) {
		this.workflowStep = workflowStep;
	}

	public WorkflowDefinition getWorkflowDefinition() {
		return this.workflowDefinition;
	}

	public void setWorkflowDefinition(WorkflowDefinition workflowDefinition) {
		this.workflowDefinition = workflowDefinition;
	}

	public int getWorkflowExpireDays() {
		return workflowExpireDays;
	}

	public void setWorkflowExpireDays(int workflowExpireDays) {
		this.workflowExpireDays = workflowExpireDays;
	}

	public int getWorkflowdetailId() {
		return workflowdetailId;
	}

	public void setWorkflowdetailId(int workflowdetailId) {
		this.workflowdetailId = workflowdetailId;
	}

}