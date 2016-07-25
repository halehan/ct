package com.halehan.ct.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the site_study_assoc database table.
 * 
 */
@Entity
@Table(name = "site_study_assoc")
@NamedQuery(name = "SiteStudyAssoc.findAll", query = "SELECT s FROM SiteStudyAssoc s")
public class SiteStudyAssoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int site_study_assocId;

	private int siteId;

	private int studyId;

	// bi-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name = "siteId", insertable = false, updatable = false)
	private Site site;

	// bi-directional many-to-one association to Study
	@ManyToOne
	@JoinColumn(name = "studyId", insertable = false, updatable = false)
	private Study study;

	public SiteStudyAssoc() {
	}

	public int getSite_study_assocId() {
		return this.site_study_assocId;
	}

	public void setSite_study_assocId(int site_study_assocId) {
		this.site_study_assocId = site_study_assocId;
	}

	public int getSiteId() {
		return this.siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getStudyId() {
		return this.studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

}