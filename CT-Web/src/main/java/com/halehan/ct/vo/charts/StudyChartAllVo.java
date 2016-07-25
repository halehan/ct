package com.halehan.ct.vo.charts;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chart")
public class StudyChartAllVo {

	private String studyName;
	private String enrolledCount;
	private String candidateCount;

	public String getStudyName() {
		return studyName;
	}
	public void setStudyName(String studyName) {
		this.studyName = studyName;
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

}
