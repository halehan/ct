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
 * The persistent class for the study_deviations database table.
 * 
 */
@Entity
@Table(name = "study_deviations")
@NamedQuery(name = "StudyDeviation.findAll", query = "SELECT s FROM StudyDeviation s")
public class StudyDeviation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int study_deviationsId;

	private String description;

	@Column(name = "updated_by")
	private int updatedBy;

	@Column(name = "updated_time")
	private Timestamp updatedTime;

	// bi-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name = "siteId")
	private Site site;

	// bi-directional many-to-one association to Study
	@ManyToOne
	@JoinColumn(name = "studyId")
	private Study study;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	// bi-directional many-to-one association to User
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "userId") private User updateUser;
	 */

	public StudyDeviation() {
	}

	public int getStudy_deviationsId() {
		return this.study_deviationsId;
	}

	public void setStudy_deviationsId(int study_deviationsId) {
		this.study_deviationsId = study_deviationsId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Study getStudy() {
		return this.study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * public User getUpdateUser() { return updateUser; }
	 * 
	 * public void setUpdateUser(User updateUser) { this.updateUser =
	 * updateUser; }
	 */

}