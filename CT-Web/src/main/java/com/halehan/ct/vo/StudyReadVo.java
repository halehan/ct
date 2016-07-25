package com.halehan.ct.vo;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.Study;
import com.halehan.ct.util.CtConstants;

@XmlRootElement(name = "studyRead")
public class StudyReadVo {

	private String studyName;
	private String studyFromMenu;
	private int studyId;

	public void copyStudy(Study study) {
		this.studyName = study.getStudyName();
		this.studyFromMenu = CtConstants.STUDY_PATIENTS + study.getStudyId();
		this.studyId = study.getStudyId();

	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getStudyFromMenu() {
		return studyFromMenu;
	}

	public void setStudyFromMenu(String studyFromMenu) {
		this.studyFromMenu = studyFromMenu;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

}
