package com.halehan.ct.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the workflow_definition database table.
 * 
 */
@Entity
@Table(name = "workflow_definition", schema = "ct")
@NamedQueries({
		@NamedQuery(name = "WorkflowDefinition.findAll", query = "SELECT w FROM WorkflowDefinition w"),
		@NamedQuery(name = "WorkflowDefinition.findDefault", query = "SELECT w FROM WorkflowDefinition w WHERE w.defaultWorkflow = 'Y'")

})
public class WorkflowDefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int workflow_definitionId;

	private String defaultWorkflow;

	private String name;

	private String updateBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDt;

	// bi-directional many-to-one association to WorkflowDetail
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "workflowDefinition")
	private List<WorkflowDetail> workflowDetails;

	public WorkflowDefinition() {
	}

	public int getWorkflow_definitionId() {
		return this.workflow_definitionId;
	}

	public void setWorkflow_definitionId(int workflow_definitionId) {
		this.workflow_definitionId = workflow_definitionId;
	}

	public String getDefaultWorkflow() {
		return this.defaultWorkflow;
	}

	public void setDefaultWorkflow(String defaultWorkflow) {
		this.defaultWorkflow = defaultWorkflow;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public List<WorkflowDetail> getWorkflowDetails() {
		return this.workflowDetails;
	}

	public void setWorkflowDetails(List<WorkflowDetail> workflowDetails) {
		this.workflowDetails = workflowDetails;
	}

	public WorkflowDetail addWorkflowDetail(WorkflowDetail workflowDetail) {
		getWorkflowDetails().add(workflowDetail);
		workflowDetail.setWorkflowDefinition(this);

		return workflowDetail;
	}

	public WorkflowDetail removeWorkflowDetail(WorkflowDetail workflowDetail) {
		getWorkflowDetails().remove(workflowDetail);
		workflowDetail.setWorkflowDefinition(null);

		return workflowDetail;
	}

}