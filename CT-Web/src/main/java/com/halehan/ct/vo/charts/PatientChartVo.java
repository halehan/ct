package com.halehan.ct.vo.charts;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")
public class PatientChartVo {

	private String patientName;
	private int patientId;
	private String studyName;
	private String expiredCount;
	private String onScheduleCount;
	public String getStudyName() {
		return studyName;
	}
	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}
	public String getExpiredCount() {
		return expiredCount;
	}
	public void setExpiredCount(String expiredCount) {
		this.expiredCount = expiredCount;
	}
	public String getOnScheduleCount() {
		return onScheduleCount;
	}
	public void setOnScheduleCount(String onScheduleCount) {
		this.onScheduleCount = onScheduleCount;
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

}
