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

import com.halehan.ct.model.Site;
import com.halehan.ct.model.SiteCounts;
import com.halehan.ct.model.SiteEquipment;
import com.halehan.ct.model.User;
import com.halehan.ct.vo.SiteCountsVo;
import com.halehan.ct.vo.SiteVo;

@Stateless
public class SiteDAO {

	@EJB
	private DAO dao;

	private List<Site> list(int first, int max) {

		return dao.namedFind(Site.class, "Site.findAll", first, max);
	}

	public List<SiteVo> findAll() {

		List<Site> siteList = this.list(0, 2000);
		List<SiteVo> siteVoList = new ArrayList<SiteVo>();

		for (Site obj : siteList) {
			SiteVo vo = new SiteVo();
			vo.copySite(obj);
			siteVoList.add(vo);
		}

		return siteVoList;

	}

	public Site findSite(int siteId) {

		return dao.find(Site.class, siteId);

	}

	public List<SiteCounts> findSiteCounts(int siteId) {

		return dao.find(SiteCounts.class,
				"SELECT s FROM SiteCounts s WHERE s.siteId = :siteId", "siteId",
				siteId);

	}

	public List<SiteCountsVo> findSiteStudyCounts(int siteId, String status) {

		List<Object[]> enrolledCounts = dao.findSiteStudyCounts(siteId, status);

		List<SiteCountsVo> counts = new ArrayList<SiteCountsVo>();

		for (Object[] obj : enrolledCounts) {
			SiteCountsVo siteCountVo = new SiteCountsVo();
			Long count = (Long) obj[0];

			siteCountVo.setName((String) obj[1]);
			siteCountVo.setPatientStatus((String) obj[2]);
			siteCountVo.setCount(count.intValue());
			siteCountVo.setSiteId((Integer) obj[3]);

			counts.add(siteCountVo);

		}

		return counts;

	}

	public SiteVo findSiteVo(int siteId) {

		Site site = findSite(siteId);
		List<SiteEquipment> siteEquipment = site.getSiteEquipments();
		List<User> sitestaff = site.getUsers();

		SiteVo siteVo = new SiteVo();

		siteVo.copySite(site);
		siteVo.copySiteEquipment(siteEquipment);
		siteVo.copySiteUser(sitestaff);

		return siteVo;

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
