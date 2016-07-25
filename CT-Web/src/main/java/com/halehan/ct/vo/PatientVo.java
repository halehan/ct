package com.halehan.ct.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.Patient;
import com.halehan.ct.model.Study;
import com.halehan.ct.view.StudyList;

@XmlRootElement(name = "patient")
public class PatientVo {

	private long patientId = 0L;

	private String birthdate = "";

	private String taskExpiration = "";

	private String fname = "";

	private String lname = "";

	private String fullName = "";

	private String mi = "";

	private String phone = "";

	private String studyId = "";

	private String studyName = "";

	private String shortName = "";

	private String studyeye = "";

	private String doctor = "";

	private String workflowName = "";

	private long patientTaskId;

	private String status = "";

	private String initialcontactdate = "";

	private String technician = "";

	private String[] doctors = {"Gupta", "Myers", "Tarrantola"};
	private String[] locations = {"Pensacola", "Ft. Walton", "Panama City"};
	private String[] studys = {"Alcon Dry macular", "Allergan Blind Eye",
			"Amgen Wet Macular", "Bausch & Lomb Wet Macular", "Merk Junky Eye",
			"Regeneron Wet Macular"};
	private String[] eyes = {"OD", "OS"};
	private List<StudyList> allStudys = new ArrayList<StudyList>();
	private List<StudyList> studyVals = new ArrayList<StudyList>();

	public PatientVo() {

	}

	public String[] getDoctors() {
		return doctors;
	}

	public void setDoctors(String[] doctors) {
		this.doctors = doctors;
	}

	public void copyPatient(Patient patient) {

		this.patientId = patient.getPatientId();

		Study study = patient.getStudy();

		this.birthdate = toString(patient.getBirthdate());
		this.fname = this.padNull(patient.getFname());
		this.lname = this.padNull(patient.getLname());
		this.fullName = this.fname + " " + this.lname;
		this.mi = this.padNull(patient.getMi());
		this.phone = this.padNull(patient.getPhone());
		this.studyId = (study == null)
				? ""
				: String.valueOf(patient.getStudy().getStudyId());
		this.studyName = (study == null)
				? ""
				: patient.getStudy().getShortName();
		this.studyeye = this.padNull(patient.getStudyeye());
		// this.doctor = this.padNull(patient.getDoctor());
		this.initialcontactdate = toString(patient.getInitialcontactdate());
		try {
			this.taskExpiration = toString(
					patient.getPatientTasks().get(0).getTaskExpireDt());
			this.patientTaskId = patient.getPatientTasks().get(0)
					.getPatientTaskId();
		} catch (Exception e) {
		}

	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMi() {
		return mi;
	}
	public void setMi(String mi) {
		this.mi = mi;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStudyeye() {
		return studyeye;
	}
	public void setStudyeye(String studyeye) {
		this.studyeye = studyeye;
	}

	private String padNull(String val) {

		String rtn = (val == null) ? "" : val;

		return rtn;

	}

	public String[] getLocations() {
		return locations;
	}

	public void setLocations(String[] locations) {
		this.locations = locations;
	}

	public String[] getStudys() {
		return studys;
	}

	public void setStudys(String[] studys) {
		this.studys = studys;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public long getPatientId() {
		return patientId;
	}

	public String[] getEyes() {
		return eyes;
	}

	public void setEyes(String[] eyes) {
		this.eyes = eyes;
	}

	public List<StudyList> getAllStudys() {
		return allStudys;
	}

	public void setAllStudys(List<StudyList> allStudys) {
		this.allStudys = allStudys;
	}

	public String getStudyId() {
		return studyId;
	}

	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}

	public List<StudyList> getStudyVals() {
		return studyVals;
	}

	public void setStudyVals(List<StudyList> studyVals) {
		this.studyVals = studyVals;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPatientTaskId() {
		return patientTaskId;
	}

	public void setPatientTaskId(long patientTaskId) {
		this.patientTaskId = patientTaskId;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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

	public String getInitialcontactdate() {
		return initialcontactdate;
	}

	public void setInitialcontactdate(String initialcontactdate) {
		this.initialcontactdate = initialcontactdate;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getTaskExpiration() {
		return taskExpiration;
	}

	public void setTaskExpiration(String taskExpiration) {
		this.taskExpiration = taskExpiration;
	}

}
