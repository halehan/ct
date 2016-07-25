package com.halehan.ct.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.halehan.ct.dao.SiteDAO;
import com.halehan.ct.dao.StudyDAO;
import com.halehan.ct.model.Patient;
import com.halehan.ct.model.PatientTask;
import com.halehan.ct.model.Site;
import com.halehan.ct.model.Study;
import com.halehan.ct.model.StudyDeviation;
import com.halehan.ct.vo.DeviationsVo;
import com.halehan.ct.vo.StudyReadVo;
import com.halehan.ct.vo.StudyVo;
import com.halehan.ct.vo.charts.StudyChartAllVo;
import com.halehan.ct.vo.charts.StudyChartVo;
import com.halehan.ct.vo.charts.StudyPatientCountsVo;

@Path("/study")
@Produces({"application/json"})
public class StudyService {

	@EJB
	private StudyDAO studyDao;
	@EJB
	private SiteDAO siteDao;

	@Path("/deviation/study/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DeviationsVo> listByStudy(@PathParam("id") String id) {

		List<StudyDeviation> deviationList = studyDao
				.listStudyDeviationByStudy(Integer.parseInt(id));
		List<DeviationsVo> deviations = new ArrayList<DeviationsVo>();

		for (StudyDeviation obj : deviationList) {
			DeviationsVo deviationsVo = new DeviationsVo();
			// deviationsVo.copyStudyDeviation(obj);
			deviations.add(deviationsVo);
		}

		return deviations;

	}

	@Path("/deviation/site/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudyPatientCountsVo> listBySite(@PathParam("id") String id) {

		return studyDao.findStudyCounts(1);

	}

	@Path("/counts/{id}")
	@GET
	public List<StudyPatientCountsVo> listByDoctor(@PathParam("id") String id) {

		return studyDao.findStudyCounts(Integer.parseInt(id));

	}

	@Path("/seed")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StudyVo seedStudy() {

		StudyVo vo = new StudyVo();

		return vo;
	}

	@Path("/list")
	@GET
	public List<StudyVo> studyList() {

		List<StudyVo> studyVoList = new ArrayList<StudyVo>();

		List<Study> studys = studyDao.list(0, 100);

		for (Study study : studys) {
			List<Patient> patientList = study.getPatients();
			StudyVo StudyVo = new StudyVo();
			StudyVo.copyStudy(study);
			studyVoList.add(StudyVo);

		}

		return studyVoList;

	}

	@Path("/list/chart/all/{id}")
	@GET
	public List<StudyChartAllVo> studyListByStudy(@PathParam("id") int id) {

		Study study = studyDao.find(id);
		Map<String, String> enrolledMap = new HashMap<String, String>();
		List enrolledPatientList = new ArrayList<String>();

		Site site = siteDao.findSite(1);
		List<Patient> patients = site.getPatients();

		for (Patient patient : patients) {

			if (patient.getStatus().equalsIgnoreCase("enrolled")) {

			}

			enrolledMap.put(patient.getStudy().getStudyName(),
					String.valueOf(patient.getPatientId()));

			System.out.print(" Study " + patient.getStudy().getStudyName());
			System.out.print(
					" " + patient.getFname() + "  " + patient.getLname());
			System.out.print(" " + patient.getStatus());
			System.out.println("  =========================   ");

		}

		List<StudyChartAllVo> studyVoList = new ArrayList<StudyChartAllVo>();

		int enrolled = 0;
		int candidate = 0;

		StudyChartAllVo vo = new StudyChartAllVo();
		List<Patient> patientList = study.getPatients();

		for (Patient patient : patientList) {
			if (patient.getStatus().equalsIgnoreCase("enrolled")) {
				enrolled++;
			} else if (patient.getStatus().equalsIgnoreCase("candidate")) {
				candidate++;
			}
		}

		StudyChartAllVo studyChartAllVo = new StudyChartAllVo();
		studyChartAllVo.setStudyName(study.getShortName().trim());
		studyChartAllVo.setEnrolledCount(enrolled + "");
		studyChartAllVo.setCandidateCount(candidate + "");
		studyVoList.add(studyChartAllVo);

		return studyVoList;

	}

	@Path("/list/chart/all")
	@GET
	public List<StudyChartAllVo> studyListAll() {

		List<StudyChartAllVo> studyVoList = new ArrayList<StudyChartAllVo>();

		List<Study> studys = studyDao.list(0, 100);

		for (Study study : studys) {
			int enrolled = 0;
			int candidate = 0;
			StudyChartAllVo vo = new StudyChartAllVo();
			List<Patient> patientList = study.getPatients();

			for (Patient patient : patientList) {
				if (patient.getStatus().equalsIgnoreCase("enrolled")) {
					enrolled++;
				} else if (patient.getStatus().equalsIgnoreCase("candidate")) {
					candidate++;
				}
			}
			StudyChartAllVo studyChartAllVo = new StudyChartAllVo();
			studyChartAllVo.setStudyName(study.getShortName());
			studyChartAllVo.setEnrolledCount(enrolled + "");
			studyChartAllVo.setCandidateCount(candidate + "");
			studyVoList.add(studyChartAllVo);

		}

		return studyVoList;

	}

	@Path("/list/chart")
	@GET
	public List<StudyChartVo> studyGraphList() {

		List<StudyChartVo> studyChartVoList = new ArrayList<StudyChartVo>();

		List<Study> studys = studyDao.list(0, 300000);

		int patientAllCnt = 0;
		int patientNewCnt = 0;
		int patientExpiredCnt = 0;
		int patientOntime = 0;
		int patientEnrolled = 0;
		int patientFailed = 0;

		for (Study study : studys) {
			StudyChartVo newStudyChartVo = new StudyChartVo();
			patientAllCnt = 0;
			patientNewCnt = 0;
			patientExpiredCnt = 0;
			patientOntime = 0;
			patientEnrolled = 0;
			patientFailed = 0;

			List<Patient> patientList = study.getPatients();
			for (Patient patient : patientList) {
				List<PatientTask> patientTaskList = patient.getPatientTasks();
				for (PatientTask patientTask : patientTaskList) {
					if (patientTask.getTaskStatus()
							.equalsIgnoreCase("expired")) {
						patientExpiredCnt++;
					} else if (patientTask.getTaskStatus()
							.equalsIgnoreCase("pending")) {
						patientOntime++;
					} else if (patientTask.getTaskStatus()
							.equalsIgnoreCase("new")) {
						patientNewCnt++;
					} else if (patientTask.getTaskStatus()
							.equalsIgnoreCase("enrolled")) {
						patientEnrolled++;
					} else if (patientTask.getTaskStatus()
							.equalsIgnoreCase("failed")) {
						patientFailed++;
					} else if (patientTask.getTaskStatus()
							.equalsIgnoreCase("complete")) {
						patientEnrolled++;
					}
				}
			}

			newStudyChartVo.setStudyName(study.getShortName());
			newStudyChartVo
					.setEnrollmentGoal(study.getStudyEnrollmentGoal() + "");
			newStudyChartVo.setExpiredCount(patientExpiredCnt + "");
			newStudyChartVo.setNewCount(patientNewCnt + "");
			newStudyChartVo.setOnScheduleCount(patientOntime + "");
			newStudyChartVo.setEnrolledCount(patientEnrolled + "");

			studyChartVoList.add(newStudyChartVo);

		}

		return studyChartVoList;

	}

	@Path("/list/read")
	@GET
	public List<StudyReadVo> studyListShort() {

		List<StudyReadVo> studyReadVoList = new ArrayList<StudyReadVo>();

		List<Study> studys = studyDao.list(0, 100);

		for (Study study : studys) {
			StudyReadVo studyReadVo = new StudyReadVo();
			studyReadVo.copyStudy(study);
			studyReadVoList.add(studyReadVo);

		}

		return studyReadVoList;

	}

	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String create(StudyVo vo) {

		/*
		 * Study studyNew = studyDao.create(vo.getCompanyName(),
		 * vo.getShortName(), vo.getDrugName(), vo.getStudyDescription(),
		 * vo.getStudyIdentifier(), vo.getPocEmail(), vo.getPocName(),
		 * vo.getPocPhone(), vo.getStudyEnrollmentGoal(), vo.getStudyName(),
		 * toDate(vo.getStartDate()), toDate(vo.getEndDate()));
		 * 
		 * StudyVo.copyStudy(studyNew);
		 */
		Study study = studyDao.create(vo);
		StudyVo studyVo = new StudyVo();
		studyVo.copyStudy(study);

		return "ok";

	}

	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String update(StudyVo vo) {

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String dateInString = "12/23/2015";
		Date date = null;

		try {

			date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		studyDao.update(vo.getStudyId(), vo.getCompanyName(), vo.getPocEmail(),
				vo.getPocName(), vo.getPocPhone(), vo.getStudyEnrollmentGoal(),
				vo.getStudyName(), "12/12/12");

		System.out.println("HERE WE ARE....  MADE IT");

		return "ok";
	}

	/*
	 * @Path("/study/get")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public StudyVo show(String id) {
	 * return studyDao.find(Integer.parseInt(id)); }
	 */

	/*
	 * @Path("/find/{id}")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public StudyVo
	 * show(@PathParam("id") int id) { return studyDao.find(id); }
	 */
	@Path("/seed")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StudyVo getNew() {
		return new StudyVo();
	}

	@Path("/delete/{id}")
	@DELETE
	public void delete(@PathParam("id") int id) {
		studyDao.delete(new Integer((int) id));
	}

	private Date toDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date convertedDate = null;
		try {
			convertedDate = sdf.parse(date);
			System.out.println(convertedDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			convertedDate = null;
		}

		return convertedDate;

	}

	private String toString(Date date) {

		String DATE_FORMAT = "MM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		System.out.println("Today is " + sdf.format(date));

		return sdf.format(date);

	}

}
