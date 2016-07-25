package com.halehan.ct.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.SiteCounts;

@XmlRootElement(name = "sitecounts")
public class SiteCountsVo {

	private int patientId;
	private int practiceId;
	private int siteId;
	private int studyId;
	private String name;
	private String siteName;
	private String patientStatus;
	private String doctor;

	@Transient
	private int count;

	public void copySiteCounts(SiteCounts siteCounts) {

		this.siteId = siteCounts.getSiteId();
		this.studyId = siteCounts.getStudyId();
		this.name = siteCounts.getStudy_name();
		this.siteName = siteCounts.getSite_name();
		this.patientStatus = siteCounts.getPatient_status();
		this.doctor = siteCounts.getDoctor();
		this.patientId = siteCounts.getPatientId();
		this.practiceId = siteCounts.getPracticeId();

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

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(int practiceId) {
		this.practiceId = practiceId;
	}

}
