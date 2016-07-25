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

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.halehan.ct.vo.DeviationsVo;
import com.halehan.ct.vo.SiteCountsVo;
import com.halehan.ct.vo.charts.DocCountsVo;

@Stateless
public class GraphDAO {

	@PersistenceContext(unitName = "ct")
	protected EntityManager em;

	public List<SiteCountsVo> findPracticeStudyCounts(int practiceId,
			String status) {

		String queryString = null;

		if (status.equalsIgnoreCase("all")) {
			queryString = "Select count(sc),  sc.study_name, sc.patient_status, sc.siteId from SiteCounts sc where sc.practiceId = :practiceId group by sc.study_name, sc.patient_status order by count(sc) desc";
		} else {
			queryString = "Select count(sc),  sc.site_name, sc.patient_status, sc.siteId from SiteCounts sc where sc.practiceId = :practiceId and sc.patient_status = :status group by sc.site_name, sc.patient_status order by count(sc) desc";
		}

		Query query = em.createQuery(queryString);

		if (status.equalsIgnoreCase("all")) {
			query.setParameter("practiceId", practiceId);
		} else {
			query.setParameter("practiceId", practiceId);
			query.setParameter("status", status);
		}

		List<Object[]> practiceCounts = query.getResultList();
		List<SiteCountsVo> counts = new ArrayList<SiteCountsVo>();

		for (Object[] obj : practiceCounts) {
			SiteCountsVo siteCountVo = new SiteCountsVo();
			Long count = (Long) obj[0];

			siteCountVo.setName((String) obj[1]);
			siteCountVo.setPatientStatus((String) obj[2]);
			siteCountVo.setCount(count.intValue());
			siteCountVo.setPracticeId((Integer) obj[3]);

			counts.add(siteCountVo);

		}

		return counts;

	}

	public List<DocCountsVo> findSiteDocCounts(int siteId) {

		Query query = em.createQuery(
				"SELECT count(p), u.lname, s.name from Site s, Patient p, User u where s.siteId = p.site.siteId and u.userId = p.doctor.userId and s.siteId = :siteId group by p.doctor.lname order by count(p) desc");

		query.setParameter("siteId", siteId);

		List<Object[]> counts = query.getResultList();

		List<DocCountsVo> docCounts = new ArrayList<DocCountsVo>();

		for (Object[] obj : counts) {
			DocCountsVo docCountsVo = new DocCountsVo();
			Long count = (Long) obj[0];

			docCountsVo.setName((String) obj[1]);
			docCountsVo.setCount(count.intValue());

			docCounts.add(docCountsVo);

		}
		return docCounts;

	}

	public List<DeviationsVo> findSiteDeviationCounts(int siteId) {

		/*
		 * select count(d.study_deviationsId), s.study_name from study s,
		 * study_deviations d, site t, user u where u.userId = d.userId and
		 * s.studyId = d.studyId and t.siteId = d.siteId and t.siteId = 1 group
		 * by s.study_name
		 */

		Query query = em.createQuery(
				"SELECT count(d), s.studyName from Study s, StudyDeviation d, Site t, User u "
						+ "where u.userId = d.user.userId and s.studyId = d.study.studyId and t.siteId = d.site.siteId and t.siteId = :siteId group by s.studyName order by count(d) desc");

		query.setParameter("siteId", siteId);

		List<Object[]> counts = query.getResultList();

		List<DeviationsVo> deviationCounts = new ArrayList<DeviationsVo>();

		for (Object[] obj : counts) {
			DeviationsVo deviationsVo = new DeviationsVo();
			Long count = (Long) obj[0];

			deviationsVo.setName((String) obj[1]);
			deviationsVo.setCount(count.intValue());

			deviationCounts.add(deviationsVo);

		}
		return deviationCounts;

	}

	public List<DeviationsVo> findSiteUserDeviationCounts(int siteId) {

		/*
		 * select count(d.study_deviationsId), s.study_name, u.fname, u.lname
		 * from study s, study_deviations d, user u where u.userId = d.userId
		 * and s.studyId = d.studyId and d.siteId = 1 group by s.study_name,
		 * u.lname
		 */

		Query query = em.createQuery(
				"SELECT count(d),  u.lname, u.fname from Study s, StudyDeviation d,  User u "
						+ "where u.userId = d.user.userId and s.studyId = d.study.studyId and d.site.siteId = :siteId group by  u.lname order by count(d) desc");

		query.setParameter("siteId", siteId);

		List<Object[]> counts = query.getResultList();

		List<DeviationsVo> deviationCounts = new ArrayList<DeviationsVo>();

		for (Object[] obj : counts) {
			DeviationsVo deviationsVo = new DeviationsVo();
			Long count = (Long) obj[0];

			// deviationsVo.setName((String) obj[1]);
			deviationsVo.setCount(count.intValue());
			deviationsVo.setName((String) obj[2] + " " + (String) obj[1]);

			deviationCounts.add(deviationsVo);

		}
		return deviationCounts;

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
