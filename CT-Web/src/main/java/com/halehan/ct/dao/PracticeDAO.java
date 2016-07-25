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

import com.halehan.ct.model.Practice;
import com.halehan.ct.model.Site;
import com.halehan.ct.model.SiteCounts;
import com.halehan.ct.vo.PracticeVo;
import com.halehan.ct.vo.SiteVo;

@Stateless
public class PracticeDAO {

	@EJB
	private DAO dao;

	private List<Practice> list(int first, int max) {

		return dao.namedFind(Practice.class, "Practice.findAll", first, max);
	}

	public List<SiteCounts> findPracticeCounts(int practiceId) {

		return dao.find(SiteCounts.class,
				"SELECT s FROM SiteCounts s WHERE s.practiceId = :practiceId",
				"practiceId", practiceId);
	}

	public List<PracticeVo> findAll() {

		List<Practice> practiceList = this.list(0, 20000);
		List<PracticeVo> practiceVoList = new ArrayList<PracticeVo>();

		for (Practice obj : practiceList) {
			PracticeVo vo = new PracticeVo();
			vo.copyPractice(obj);
			practiceVoList.add(vo);
		}

		return practiceVoList;

	}

	public PracticeVo findPractice(int practiceId) {

		Practice practice = dao.find(Practice.class, practiceId);
		List<Site> sites = practice.getSites();

		PracticeVo practiceVo = new PracticeVo();
		List<SiteVo> siteVoList = new ArrayList<SiteVo>();

		for (Site obj : sites) {
			SiteVo site = new SiteVo();
			site.copySite(obj);
			siteVoList.add(site);
		}

		practiceVo.copyPractice(practice);
		practiceVo.setSites(siteVoList);

		return practiceVo;

	}

	public Practice create(PracticeVo vo) {

		Practice practiceObj = new Practice();

		practiceObj.setAbbreviatedName(vo.getAbbreviatedName());
		practiceObj.setName(vo.getName());
		practiceObj.setAddress(vo.getAddress());

		return dao.create(practiceObj);
	}

	public Practice create(String name, String abbreviatedName,
			String address) {

		Practice practiceObj = new Practice();
		practiceObj.setName(name);
		practiceObj.setAbbreviatedName(abbreviatedName);
		practiceObj.setAddress(address);

		return dao.create(practiceObj);
	}

	public void delete(long id) {
		dao.delete(Practice.class, id);
	}

	public PracticeVo update(int id, String abbreviatedName, String name) {

		Practice practiceObj = dao.find(Practice.class, id);
		practiceObj.setPracticeId(id);
		practiceObj.setAbbreviatedName(abbreviatedName);
		practiceObj.setName(name);

		dao.update(practiceObj);

		PracticeVo practiceVo = new PracticeVo();
		practiceVo.copyPractice(practiceObj);

		return practiceVo;
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
