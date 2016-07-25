package com.halehan.ct.vo.charts;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.Study;
import com.halehan.ct.util.CtConstants;

@XmlRootElement(name = "study")
public class StudyVo {

	private int studyId;

	private String studyCount;
	private String studyName;
	private String shortName;
	private String studyDescription;
	private String drugName;
	private String studyIdentifier;
	private String studyUrl;
	private String studyFromMenu;
	private String companyName;

	private String pocName;
	private String pocPhone;
	private String pocEmail;
	private int studyEnrollmentGoal;
	private String updateDate;
	private String startDate;
	private String endDate;

	public void copyStudy(Study study) {
		this.studyId = study.getStudyId();
		this.drugName = study.getDrugName();
		this.studyIdentifier = study.getStudyIdentifier();
		this.studyUrl = CtConstants.CLINICAL_TRIALS_GOV
				+ study.getStudyIdentifier();
		this.companyName = study.getCompanyName();
		this.studyName = study.getStudyName();
		this.pocName = study.getPocName();
		this.pocPhone = study.getPocPhone();
		this.pocEmail = study.getPocEmail();
		this.studyEnrollmentGoal = study.getStudyEnrollmentGoal();
		this.updateDate = toString(study.getUpdateDt());
		this.studyFromMenu = CtConstants.STUDY_PATIENTS + study.getStudyId();
		this.startDate = toString(study.getStartDt());
		this.endDate = toString(study.getEndDt());

	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getPocName() {
		return pocName;
	}

	public void setPocName(String pocName) {
		this.pocName = pocName;
	}

	public String getPocPhone() {
		return pocPhone;
	}

	public void setPocPhone(String pocPhone) {
		this.pocPhone = pocPhone;
	}

	public String getPocEmail() {
		return pocEmail;
	}

	public void setPocEmail(String pocEmail) {
		this.pocEmail = pocEmail;
	}

	public int getStudyEnrollmentGoal() {
		return studyEnrollmentGoal;
	}

	public void setStudyEnrollmentGoal(int studyEnrollmentGoal) {
		this.studyEnrollmentGoal = studyEnrollmentGoal;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getStudyIdentifier() {
		return studyIdentifier;
	}

	public void setStudyIdentifier(String studyIdentifier) {
		this.studyIdentifier = studyIdentifier;
	}

	public String getStudyUrl() {
		return studyUrl;
	}

	public void setStudyUrl(String studyUrl) {
		this.studyUrl = studyUrl;
	}

	public String getStudyFromMenu() {
		return studyFromMenu;
	}

	public void setStudyFromMenu(String studyFromMenu) {
		this.studyFromMenu = studyFromMenu;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getStudyDescription() {
		return studyDescription;
	}

	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getStudyCount() {
		return studyCount;
	}

	public void setStudyCount(String studyCount) {
		this.studyCount = studyCount;
	}

}
