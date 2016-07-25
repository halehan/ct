/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
    * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.halehan.ct.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.joda.time.DateTime;

import com.halehan.ct.model.Patient;
import com.halehan.ct.model.PatientTask;
import com.halehan.ct.model.Role;
import com.halehan.ct.model.SiteEquipment;
import com.halehan.ct.model.Study;
import com.halehan.ct.model.User;
import com.halehan.ct.model.WorkflowDefinition;
import com.halehan.ct.model.WorkflowDetail;
import com.halehan.ct.vo.PatientTaskVo;
import com.halehan.ct.vo.PatientVo;
import com.halehan.ct.vo.SiteEquipmentVo;

@Stateless
public class MiscDAO {

	@EJB
	private DAO dao;

	public List<User> findUserBySite(int siteId) {

		return dao.find(User.class,
				"SELECT u FROM User u WHERE  u.site.siteId = :siteId", "siteId",
				siteId);

	}

	public SiteEquipment findSiteEquipmentById(int id) {

		return dao.find(SiteEquipment.class, id);

	}

	public List<SiteEquipment> findSiteEquipmentBySite(int siteId) {

		return dao.find(SiteEquipment.class,
				"SELECT u FROM SiteEquipment u WHERE  u.site.siteId = :siteId",
				"siteId", siteId);

	}

	public List<User> listBySite(int siteId, int first, int max) {

		return dao.namedFind(User.class, "User.findAll", first, max);

	}

	public List<Role> roleList(int first, int max) {

		return dao.namedFind(Role.class, "Role.findAll", first, max);

	}

	public List<Patient> listNew(int first, int max) {
		return dao.namedFind(Patient.class, "Patient.findNew", first, max);
	}

	public List<Patient> listExpired(int first, int max) {
		return dao.namedFind(Patient.class, "Patient.findExpired", first, max);
	}

	public List<Patient> listEnrolled(int first, int max) {
		return dao.namedFind(Patient.class, "Patient.findEnrolled", first, max);
	}

	public User create(User user) {
		return dao.create(user);
	}

	public Patient create(Date birthdate, String fname, String lname, String mi,
			String phone, Study study, String studyeye, Date initialContactDate,
			String doctor, String clinician) {

		int studyCast = 0;

		/*
		 * try{ studyCast = Integer.parseInt(study); } catch (Exception e) {
		 * studyCast = 1; }
		 */
		// Need to format birthdate;

		Patient patient = new Patient();

		patient.setBirthdate(birthdate);
		patient.setFname(fname);
		patient.setLname(lname);
		patient.setMi(mi);
		patient.setPhone(phone);
		patient.setStudy(study);
		patient.setStudyeye(studyeye);
		// patient.setDoctor(doctor);
		patient.setInitialcontactdate(initialContactDate);
		patient.setStatus("candidate");

		Patient patientRtn = dao.create(patient);

		System.out.println("Patient ID = " + patient.getPatientId());

		// List<Workflow> workFlowList = this
		// .getWorkFlowByStudyStep(study.getStudyId(), "1");

		WorkflowDefinition workflowDefinition = this.getDefaultWorkflow()
				.get(0);

		WorkflowDetail detail = workflowDefinition.getWorkflowDetails().get(0);

		// Workflow workFlow = workFlowList.get(0);

		// Add the expiration (int) to the start date which will default to
		// today.
		// take Date() and add expireDuration days to it for the
		// task_expire_datye that will be in the patientTask
		// table

		Date startDate = patient.getInitialcontactdate();
		DateTime createdDate = new DateTime(startDate);
		// DateTime expirationDate = createdDate
		// .plusDays(workFlow.getExpireDuration());

		DateTime expirationDate = createdDate
				.plusDays(detail.getWorkflowExpireDays());

		// Add row to the patientTask table
		PatientTask patientTask = new PatientTask();
		patientTask.setPatient(patient);
		// patientTask.setWorkflow(workFlow);
		patientTask.setWorkflowDetail(detail);
		patientTask.setTaskStartDt(createdDate.toDate());
		patientTask.setTaskExpireDt(expirationDate.toDate());
		patientTask.setTaskStatus("new");
		patientTask.setTaskNotes("Inital Task.  Patient Candidate Create");

		dao.create(patientTask);

		return patient;
	}

	public User find(int id) {

		User user = dao.find(User.class, id);

		return user;
	}

	public void delete(int id) {
		// System.out.println("Deleted user + " + id);
		dao.delete(User.class, id);
	}

	public void deleteEquipment(int id) {
		dao.delete(SiteEquipment.class, id);
	}

	public List<WorkflowDefinition> getDefaultWorkflow() {

		return dao.namedFind(WorkflowDefinition.class,
				"WorkflowDefinition.findDefault", 0, 100);

	}

	public SiteEquipmentVo update(SiteEquipmentVo siteEquipmentVo) {

		SiteEquipment siteEquipment = dao.find(SiteEquipment.class,
				siteEquipmentVo.getSite_equipmentId());

		siteEquipment.setLocation(siteEquipmentVo.getLocation());
		siteEquipment.setManufacturer(siteEquipmentVo.getManufacturer());
		siteEquipment.setName(siteEquipmentVo.getName());
		siteEquipment.setSerialNumber(siteEquipmentVo.getSerialNumber());
		siteEquipment.setType(siteEquipmentVo.getType());

		dao.update(siteEquipment);

		return siteEquipmentVo;

	}

	public PatientVo update(long id, Date birthdate, String fname, String lname,
			String mi, String phone, String study, String studyeye,
			String doctor, Date initialContact, String technician) {

		Date birthDate = new Date();
		int studyCast = 1;

		Patient patient = dao.find(Patient.class, id);
		Study _study = dao.find(Study.class, Integer.valueOf(study).intValue());
		if (patient == null) {
			throw new IllegalArgumentException(
					"setUser id " + id + " not found");
		}

		try {
			studyCast = Integer.parseInt(study);

		} catch (Exception e) {

		}

		patient.setPatientId(id);
		patient.setBirthdate(birthdate);
		patient.setFname(fname);
		patient.setLname(lname);
		patient.setMi(mi);
		patient.setPhone(phone);
		patient.setStudy(_study);
		patient.setStudyeye(studyeye);
		// patient.setDoctor(doctor);
		patient.setInitialcontactdate(initialContact);

		dao.update(patient);

		PatientVo patientVo = new PatientVo();
		patientVo.copyPatient(patient);

		return patientVo;
	}

	public PatientTask updatePatientTask(PatientTask task) {
		return dao.update(task);
	}

	public PatientTaskVo updatePatientTask(long patientTaskId, String taskNotes,
			Date taskStartDt, Date taskExpireDt, Date taskCompleteDt,
			String taskStatus) {

		Date birthDate = new Date();
		int studyCast = 1;

		PatientTask patientTask = dao.find(PatientTask.class, patientTaskId);
		if (patientTask == null) {
			throw new IllegalArgumentException(
					"setUser id " + patientTaskId + " not found");
		}

		patientTask.setPatientTaskId(patientTaskId);
		patientTask.setTaskNotes(taskNotes);
		patientTask.setTaskStartDt(taskStartDt);
		patientTask.setTaskExpireDt(taskExpireDt);
		patientTask.setTaskCompleteDt(taskCompleteDt);

		patientTask.setTaskStatus(taskStatus);

		dao.update(patientTask);

		PatientTaskVo patientTaskVo = new PatientTaskVo();
		patientTaskVo.copyPatientTask(patientTask);

		return patientTaskVo;
	}

	public Patient updatePatient(Patient patient) {
		Patient updated = dao.update(patient);

		// PatientTaskVo patientTaskVo = new PatientTaskVo();
		// patientTaskVo.copyPatientTask(patientTask);

		return updated;
	}

}
