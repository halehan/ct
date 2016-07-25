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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.halehan.ct.model.Study;
import com.halehan.ct.model.StudyDeviation;
import com.halehan.ct.vo.StudyVo;
import com.halehan.ct.vo.charts.StudyPatientCountsVo;

@Stateless
public class StudyDAO {

	@EJB
	private DAO dao;

	public List<StudyDeviation> listStudyDeviationAll(int first, int max) {

		return dao.namedFind(StudyDeviation.class, "StudyDeviation.findAll",
				first, max);
	}

	public List<StudyDeviation> listStudyDeviationBySite(int siteId) {

		return dao.find(StudyDeviation.class,
				"SELECT s FROM Site s WHERE s.siteId = :siteId", "siteId",
				siteId);
	}

	public List<StudyDeviation> listStudyDeviationByStudy(int studyId) {

		return dao.find(StudyDeviation.class,
				"SELECT s FROM StudyDeviation s WHERE s.study.studyId = :studyId",
				"studyId", studyId);
	}

	public List<Study> list(int first, int max) {

		return dao.namedFind(Study.class, "Study.findAll", first, max);
	}

	public List<StudyPatientCountsVo> findStudyCounts(int studyId) {

		List<Object[]> enrolledCounts = dao.findStudyCounts(studyId,
				"enrolled");
		List<Object[]> candidateCounts = dao.findStudyCounts(studyId,
				"candidate");

		Object[] enrolled = enrolledCounts.get(0);
		Object[] candidate = candidateCounts.get(0);

		StudyPatientCountsVo vo = new StudyPatientCountsVo();
		List<StudyPatientCountsVo> countsList = new ArrayList<StudyPatientCountsVo>();

		for (Object[] obj : enrolledCounts) {

			System.out.println("Study Name = " + enrolled[0]);
			System.out.println("Enrolled Count = " + enrolled[1]);
			System.out.println("Candidate Count = " + candidate[1]);
			System.out.println("Study Goal = " + enrolled[2]);

			vo.setStudy(String.valueOf(enrolled[0]));
			vo.setEnrolledCount(String.valueOf(enrolled[1]));
			vo.setCandidateCount(String.valueOf(candidate[1]));
			vo.setGoalCount((String.valueOf(enrolled[2])));

			countsList.add(vo);

		}

		return countsList;

	}

	public Study create(StudyVo vo) {

		Date createdate = new Date();

		Study studyObj = new Study();

		studyObj.setCompanyName(vo.getCompanyName());
		studyObj.setPocEmail(vo.getPocEmail());
		studyObj.setPocName(vo.getPocName());
		studyObj.setStudyEnrollmentGoal(vo.getStudyEnrollmentGoal());
		studyObj.setStudyName(vo.getStudyName());
		studyObj.setUpdateDt(createdate);
		studyObj.setPocPhone(vo.getPocPhone());
		studyObj.setDrugName(vo.getDrugName());
		studyObj.setStudyDescription(vo.getStudyDescription());
		studyObj.setStudyIdentifier(vo.getStudyIdentifier());
		studyObj.setShortName(vo.getShortName());
		studyObj.setStartDt(toDate(vo.getStartDate()));
		studyObj.setEndDt(toDate(vo.getEndDate()));

		return dao.create(studyObj);
	}

	public Study create(String companyName, String shortName, String drugName,
			String studyDescription, String studyIdentifier, String pocEmail,
			String pocName, String pocPhone, int studyEnrollmentGoal,
			String studyName, Date startDt, Date endDt) {

		Date createdate = new Date();

		Study studyObj = new Study();

		studyObj.setCompanyName(companyName);
		studyObj.setPocEmail(pocEmail);
		studyObj.setPocName(pocName);
		studyObj.setStudyEnrollmentGoal(studyEnrollmentGoal);
		studyObj.setStudyName(studyName);
		studyObj.setStartDt(startDt);
		studyObj.setEndDt(endDt);
		studyObj.setUpdateDt(createdate);
		studyObj.setPocPhone(pocPhone);
		studyObj.setDrugName(drugName);
		studyObj.setStudyDescription(studyDescription);
		studyObj.setStudyIdentifier(studyIdentifier);
		studyObj.setShortName(shortName);

		return dao.create(studyObj);
	}

	public Study find(int id) {
		return dao.find(Study.class, id);

	}

	public void delete(long id) {
		dao.delete(Study.class, id);
	}

	public StudyVo update(long id, String companyName, String pocEmail,
			String pocName, String pocPhone, int studyEnrollmentGoal,
			String studyName, String updateDt) {

		Date updateDate = new Date();
		int studyCast = 1;

		Study studyObj = dao.find(Study.class, id);

		if (studyObj == null) {
			throw new IllegalArgumentException(
					"setUser id " + id + " not found");
		}

		studyObj.setCompanyName(companyName);
		studyObj.setPocEmail(pocEmail);
		studyObj.setPocName(pocName);
		studyObj.setPocPhone(pocPhone);
		studyObj.setStudyEnrollmentGoal(studyEnrollmentGoal);
		studyObj.setStudyName(studyName);
		studyObj.setUpdateDt(updateDate);

		dao.update(studyObj);

		StudyVo StudyVo = new StudyVo();
		StudyVo.copyStudy(studyObj);

		return StudyVo;
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
