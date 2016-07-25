package com.halehan.ct.vo.charts;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chart")
public class StudyPatientCountsVo {

	private String study;
	private String enrolledCount;
	private String candidateCount;
	private String goalCount;

	public String getStudy() {
		return study;
	}
	public void setStudy(String study) {
		this.study = study;
	}
	public String getEnrolledCount() {
		return enrolledCount;
	}
	public void setEnrolledCount(String enrolledCount) {
		this.enrolledCount = enrolledCount;
	}
	public String getCandidateCount() {
		return candidateCount;
	}
	public void setCandidateCount(String candidateCount) {
		this.candidateCount = candidateCount;
	}
	public String getGoalCount() {
		return goalCount;
	}
	public void setGoalCount(String goalCount) {
		this.goalCount = goalCount;
	}

}
