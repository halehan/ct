package com.halehan.ct.vo.charts;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "study")
public class StudyChartVo {

	private int studyId;

	private String studyCount;
	private String studyName;
	private String newCount;
	private String expiredCount;
	private String onScheduleCount;
	private String failedScreenCount;
	private String enrolledCount;
	private String enrollmentGoal;

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public String getStudyCount() {
		return studyCount;
	}

	public void setStudyCount(String studyCount) {
		this.studyCount = studyCount;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getNewCount() {
		return newCount;
	}

	public void setNewCount(String newCount) {
		this.newCount = newCount;
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

	public String getFailedScreenCount() {
		return failedScreenCount;
	}

	public void setFailedScreenCount(String failedScreenCount) {
		this.failedScreenCount = failedScreenCount;
	}

	public String getEnrolledCount() {
		return enrolledCount;
	}

	public void setEnrolledCount(String enrolledCount) {
		this.enrolledCount = enrolledCount;
	}

	public String getEnrollmentGoal() {
		return enrollmentGoal;
	}

	public void setEnrollmentGoal(String enrollmentGoal) {
		this.enrollmentGoal = enrollmentGoal;
	}

}
