package com.halehan.ct.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;

import com.halehan.ct.dao.PatientDAO;
import com.halehan.ct.dao.StudyDAO;
import com.halehan.ct.model.Patient;
import com.halehan.ct.model.PatientTask;
import com.halehan.ct.model.Study;
import com.halehan.ct.model.WorkflowDefinition;
import com.halehan.ct.model.WorkflowDetail;
import com.halehan.ct.view.StudyList;
import com.halehan.ct.vo.PatientReadVo;
import com.halehan.ct.vo.PatientTaskVo;
import com.halehan.ct.vo.PatientVo;
import com.halehan.ct.vo.charts.DoctorStudyChartVo;
import com.halehan.ct.vo.charts.PatientChartOneVo;
import com.halehan.ct.vo.charts.PatientStudyTaskVo;

@Path("/patient")
@Produces({"application/json"})
public class PatientService {

	public final String NEW = "new";
	public final String EXPIRED = "expired";
	public final String PENDING = "pending";

	@EJB
	private PatientDAO patientDao;
	@EJB
	private StudyDAO studyDao;

	List<StudyList> studyVals = null;

	@Path("/list/chart/doc/all/{id}")
	@GET
	public List<DoctorStudyChartVo> listByDoctor(@PathParam("id") String id) {

		return patientDao.findDocCount(Integer.parseInt(id));

	}

	/*
	 * This Chart will list the patients workflow status for each patient
	 * patient counts will consist of new, pending and expired tasks. A patient
	 * can have a (new or expired task) or a (pending or expired task)
	 */
	@Path("/chartOne/list")
	@GET
	public List<PatientChartOneVo> patientChartOneList() {

		List<PatientChartOneVo> patientChartVoList = new ArrayList<PatientChartOneVo>();

		List<Patient> patients = patientDao.listAll(0, 1000);

		int exipiredCnt = 0;
		int onScheduleCnt = 0;

		for (Patient patient : patients) {

			if (patient.getStatus().equalsIgnoreCase("candidate")) {
				List<PatientTask> tasks = patient.getPatientTasks();
				for (PatientTask task : tasks) {
					if (task.getTaskStatus().equalsIgnoreCase("new") || task
							.getTaskStatus().equalsIgnoreCase("pending")) {
						onScheduleCnt++;
					} else if (task.getTaskStatus()
							.equalsIgnoreCase("expired")) {
						exipiredCnt++;
					}
				}

			}

		}

		PatientChartOneVo expiredVo = new PatientChartOneVo();
		expiredVo.setCount(exipiredCnt + "");
		expiredVo.setStatus("Expired");
		patientChartVoList.add(expiredVo);

		PatientChartOneVo onScheddVo = new PatientChartOneVo();
		onScheddVo.setCount(onScheduleCnt + "");
		onScheddVo.setStatus("On Schedule");
		patientChartVoList.add(onScheddVo);

		return patientChartVoList;

	}

	@Path("/list/all/enrolled")
	@GET
	public List<PatientVo> patientEnrolledList() {

		List<PatientVo> patientVoList = new ArrayList<PatientVo>();

		List<Patient> patients = patientDao.listEnrolled(0, 1000);

		for (Patient patient : patients) {
			List<PatientTask> tasks = patient.getPatientTasks();
			PatientVo patientVo = new PatientVo();
			patientVo.copyPatient(patient);
			if (tasks.size() > 0) {
				for (PatientTask task : tasks) {
					patientVo.setStatus(task.getTaskStatus());
					// patientVo.setWorkflowName(task.getWorkflow().getName());
					patientVo.setWorkflowName(
							task.getWorkflowDetail().getWorkflowName());
					patientVo.setPatientTaskId(task.getPatientTaskId());
					patientVo.setTaskExpiration(
							toString(task.getTaskExpireDt()));
				}
			}
			patientVoList.add(patientVo);
		}

		return patientVoList;

	}

	@Path("/list")
	@GET
	public List<PatientReadVo> patientList() {

		List<PatientReadVo> patientVoList = new ArrayList<PatientReadVo>();

		List<Patient> patients = patientDao.list(0, 1000);

		for (Patient patient : patients) {
			List<PatientTask> tasks = patient.getPatientTasks();
			PatientReadVo patientVo = new PatientReadVo();
			patientVo.copyPatient(patient);
			if (tasks.size() > 0) {
				for (PatientTask task : tasks) {
					if (task.getTaskStatus().trim()
							.equalsIgnoreCase("pending")) {
						patientVo.setStatus(task.getTaskStatus());
						// patientVo.setWorkflowName(task.getWorkflow().getName());
						patientVo.setWorkflowName(
								task.getWorkflowDetail().getWorkflowName());
						patientVo.setPatientTaskId(task.getPatientTaskId());
						patientVo.setTaskExpiration(
								toString(task.getTaskExpireDt()));
					}
				}
			}

			patientVoList.add(patientVo);

		}

		for (PatientReadVo patient : patientVoList) {
			System.out.println(patient.getFullName());

		}

		return patientVoList;

	}

	/*
	 * @Path("/list/new")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<PatientVo>
	 * patientListNew() {
	 * 
	 * List<PatientVo> newPatientVoList = new ArrayList<PatientVo>();
	 * 
	 * List<Patient> newPatients = patientDao.listNew(0, 10000);
	 * 
	 * for (Patient patient : newPatients) { List<PatientTask> tasks =
	 * patient.getPatientTasks(); PatientVo patientVo = new PatientVo();
	 * patientVo.copyPatient(patient); if (tasks.size() > 0) {
	 * patientVo.setStatus(tasks.get(0).getTaskStatus());
	 * patientVo.setWorkflowName(tasks.get(0).getWorkflow().getName());
	 * patientVo.setPatientTaskId(tasks.get(0).getPatientTaskId()); }
	 * newPatientVoList.add(patientVo);
	 * 
	 * }
	 * 
	 * return newPatientVoList;
	 * 
	 * }
	 */

	@Path("/list/{type}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PatientVo> patientListExpired(@PathParam("type") String type) {

		// Need to move this out into a scheduled job
		this.updateExirationDates();

		List<PatientVo> expiredPatientVoList = new ArrayList<PatientVo>();
		List<Patient> patients = null;

		if (type.equalsIgnoreCase(NEW)) {
			patients = patientDao.listNew(0, 1000);
		} else if (type.equalsIgnoreCase(EXPIRED)) {
			patients = patientDao.listExpired(0, 1000);
		} else if (type.equalsIgnoreCase(PENDING)) {
			patients = patientDao.list(0, 1000);
		}

		for (Patient patient : patients) {
			List<PatientTask> tasks = patient.getPatientTasks();

			for (PatientTask task : tasks) {
				if (task.getTaskStatus().equalsIgnoreCase(type)) {

					PatientVo patientVo = new PatientVo();
					patientVo.copyPatient(patient);

					patientVo.setStatus(task.getTaskStatus());
					// patientVo.setWorkflowName(task.getWorkflow().getName());
					patientVo.setWorkflowName(
							task.getWorkflowDetail().getWorkflowName());
					patientVo.setPatientTaskId(task.getPatientTaskId());

					expiredPatientVoList.add(patientVo);

				}
			}

		}

		return expiredPatientVoList;

	}

	@Path("/list/site/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PatientVo> patientListSite(@PathParam("id") int id) {

		List<Patient> patients = patientDao.findBySite(id);
		List<PatientVo> voList = new ArrayList<PatientVo>();

		for (Patient patient : patients) {

			PatientVo patientVo = new PatientVo();
			patientVo.copyPatient(patient);
			voList.add(patientVo);

		}

		return voList;

	}

	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String create(PatientVo vo) {

		PatientVo patientVo = new PatientVo();
		Study studyObj = studyDao.find(Integer.parseInt(vo.getStudyId()));

		Patient patientNew = patientDao.create(this.toDate(vo.getBirthdate()),
				vo.getFname(), vo.getLname(), vo.getMi(), vo.getPhone(),
				studyObj, vo.getStudyeye(),
				this.toDate(vo.getInitialcontactdate()), vo.getDoctor(),
				"Sherika");

		return "ok";

	}

	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String update(PatientVo vo) {

		/*
		 * SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		 * String dateInString = "12/23/2015"; Date date = null;
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); Date
		 * convertedCurrentDate = null; try { convertedCurrentDate =
		 * sdf.parse(vo.getBirthdate());
		 * System.out.println(convertedCurrentDate); } catch (ParseException e1)
		 * { // TODO Auto-generated catch block e1.printStackTrace(); }
		 * 
		 * try {
		 * 
		 * System.out.println(vo.getBirthdate()); date =
		 * formatter.parse(dateInString); System.out.println(date);
		 * System.out.println(formatter.format(date));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */

		patientDao.update(vo.getPatientId(), this.toDate(vo.getBirthdate()),
				vo.getFname(), vo.getLname(), vo.getMi(), vo.getPhone(),
				vo.getStudyId(), vo.getStudyeye(), vo.getDoctor(),
				this.toDate(vo.getInitialcontactdate()), "Sherika");

		return "success";
	}

	private void seedTask(PatientTaskVo vo) {

		System.out.println("******Step = " + vo.getStep());;

		Study study = studyDao.find((int) vo.getStudyId());
		// List<Workflow> workFlowList = study.getWorfkflows();

		List<WorkflowDefinition> workFlowLst = patientDao.getDefaultWorkflow();
		List<WorkflowDetail> workFlowDetailLst = workFlowLst.get(0)
				.getWorkflowDetails();

		Map<Integer, WorkflowDetail> stepMap = new HashMap<Integer, WorkflowDetail>();

		for (WorkflowDetail detail : workFlowDetailLst)
			stepMap.put(new Integer(detail.getWorkflowStep()), detail);

		Patient patient = patientDao.find((int) vo.getPatientId());
		// int size = workFlowList.size();

		int size = workFlowDetailLst.size();
		Integer step = new Integer(vo.getStep());

		if (Integer.valueOf(vo.getStep()) < size) {
			step++;

			WorkflowDetail detail = stepMap.get(Integer.valueOf(step));
			// WorkflowDetail detail = workFlowDetailLst
			// .get(Integer.valueOf(vo.getStep()));
			// Workflow workflow =
			// workFlowList.get(Integer.valueOf(vo.getStep()));
			PatientTask patientTask = new PatientTask();

			Date startDate = new Date();
			DateTime createdDate = new DateTime(startDate);
			DateTime expirationDate = createdDate
					.plusDays(detail.getWorkflowExpireDays());

			patientTask.setPatient(patient);
			// patientTask.setWorkflow(workflow);
			patientTask.setWorkflowDetail(detail);
			patientTask.setTaskExpireDt(expirationDate.toDate());
			patientTask.setTaskStartDt(createdDate.toDate());
			patientTask.setTaskStatus("pending");
			patientTask.setTaskNotes(
					"Starting New Task " + detail.getWorkflowName() + "  Step "
							+ detail.getWorkflowStep());

			patientDao.create(patientTask);
			// Create new PatientTask for this user

		} else {
			patient.setStatus("enrolled");
			patientDao.updatePatient(patient);
		}

		System.out.println(vo.getStudyId());
		System.out.println(vo.getStep());

	}

	@Path("/task/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String update(PatientTaskVo vo) {

		// If someone updates a new Patient we want to change status to Pending
		if (vo.getTaskStatus().equalsIgnoreCase("new")) {
			vo.setTaskStatus("pending");
		}

		// If Step is finished que up the next step
		if (vo.isFinishTask()) {

			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

			// Get the date today using Calendar object.
			Date today = Calendar.getInstance().getTime();

			// Using DateFormat format method we can create a string
			// representation of a date with the defined format.
			String finishDate = df.format(today);
			vo.setTaskComplete(finishDate);

			// Date startDate = patient.getInitialcontactdate();
			// DateTime createdDate = new DateTime(startDate);
			// DateTime expirationDate =
			// createdDate.plusDays(workFlow.getExpireDuration());

			vo.setTaskStatus("complete");

		}

		try {

			patientDao.updatePatientTask(vo.getPatientTaskId(),
					vo.getTaskNotes(), this.toDate(vo.getTaskStart()),
					this.toDate(vo.getTaskExpiration()),
					this.toDate(vo.getTaskComplete()),
					vo.unMaskStatus(vo.getTaskStatus()));

			if (vo.isFinishTask()) {
				this.seedTask(vo);
			}

		} catch (Exception e) {
			return e.getMessage();
		}

		return "success";
	}

	/*
	 * @Path("/patient/get")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public PatientVo show(String id) {
	 * return patientDao.find(Integer.parseInt(id)); }
	 */

	@Path("/find/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PatientVo show(@PathParam("id") int id) {
		PatientVo patientVo = new PatientVo();

		Patient patient = patientDao.find(id);

		patientVo.copyPatient(patient);

		patientVo.setStudyVals(getStudyVals());

		return patientVo;
	}

	@Path("/findByStudy/{type}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PatientReadVo> findByStudy(@PathParam("id") int id,
			@PathParam("type") String type) {

		List<Patient> patients = patientDao.findByStudy(id, type);

		List<PatientReadVo> patientVoList = new ArrayList<PatientReadVo>();

		for (Patient patient : patients) {
			PatientReadVo patientReadVo = new PatientReadVo();
			patientReadVo.copyPatient(patient);
			patientVoList.add(patientReadVo);
		}

		return patientVoList;
	}

	@Path("/task/find/report/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PatientStudyTaskVo> findPatientTaskreport(
			@PathParam("id") int id) {

		List<PatientStudyTaskVo> taskList = new ArrayList<PatientStudyTaskVo>();
		Patient patient = patientDao.find(id);
		List<PatientTask> patientTaskList = patient.getPatientTasks();

		for (PatientTask task : patientTaskList) {
			PatientStudyTaskVo patientTaskVo = new PatientStudyTaskVo();

			patientTaskVo.setStudyName(patient.getStudy().getStudyName());
			patientTaskVo.setNotes(task.getTaskNotes());
			patientTaskVo.setPatientId((int) patient.getPatientId());
			patientTaskVo.setPatientName(
					patient.getFname() + " " + patient.getLname());
			// patientTaskVo.setWorkflowName(task.getWorkflow().getName());
			patientTaskVo.setWorkflowName(
					task.getWorkflowDetail().getWorkflowName());
			patientTaskVo.setStartDt(toString(task.getTaskStartDt()));
			patientTaskVo.setFinishDt(toString(task.getTaskCompleteDt()));
			patientTaskVo.setPatientTaskId((int) task.getPatientTaskId());

			taskList.add(patientTaskVo);

		}

		return taskList;
	}

	private List<StudyList> getStudyVals() {

		if (studyVals == null || studyVals.isEmpty()) {
			studyVals = new ArrayList<StudyList>();

			List<Study> studyList = studyDao.list(0, 100);
			for (Study study : studyList) {

				StudyList studyObj = new StudyList();
				studyObj.setStudyName(study.getStudyName());
				studyObj.setStudyId("" + study.getStudyId());
				studyVals.add(studyObj);

			}

		}

		return studyVals;

	}

	@Path("/task/find/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PatientTaskVo findPatientTask(@PathParam("id") int id) {
		PatientTaskVo patientTaskVo = new PatientTaskVo();

		PatientTask patientTask = patientDao.findPatientTask(id);

		patientTaskVo.copyPatientTask(patientTask);

		return patientTaskVo;
	}

	/*
	 * method takes a blank PatientVo and send back to newPatient UI
	 */

	@Path("/seed")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PatientVo getNew() {

		PatientVo vo = new PatientVo();

		// Add DB driven lookups
		vo.setStudyVals(getStudyVals());

		return vo;
	}

	@Path("/remove/{id}")
	@DELETE
	public void delete(@PathParam("id") int id) {
		patientDao.delete(new Integer((int) id));
	}

	private Date toDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date convertedDate = null;
		try {
			convertedDate = sdf.parse(date);
			System.out.println(convertedDate);
		} catch (ParseException e1) {
			convertedDate = null;
		}

		return convertedDate;

	}

	private String toString(Date date) {

		String rtnDate = null;

		if (!(date == null)) {

			String DATE_FORMAT = "MM/dd/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			System.out.println("Today is " + sdf.format(date));

			rtnDate = sdf.format(date);
		} else {
			rtnDate = "";
		}

		return rtnDate;

	}

	private void updateExirationDates() {
		List<PatientTask> tasks = patientDao.findAllPatientTasks(0, 1000);

		Date today = new Date();

		for (PatientTask task : tasks) {
			if (!(task.getTaskStatus().equalsIgnoreCase("complete"))) {
				if (task.getTaskExpireDt().before(today)) {
					task.setTaskStatus("expired");
					patientDao.updatePatientTask(task);
				}

			}
		}

	}

}
