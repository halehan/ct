/*
 *     Licensed to the Apache Software Foundation (ASF) under one or more
 *     contributor license agreements.  See the NOTICE file distributed with
 *     this work for additional information regarding copyright ownership.
 *     The ASF licenses this file to You under the Apache License, Version 2.0
 *     (the "License"); you may not use this file except in compliance with
 *     the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package com.halehan.ct.dao;

import java.util.List;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Simply maps the entitymanager. It simplifies refactoring (unitName change)
 * and wraps some logic (limited queries).
 */
@Singleton
@Lock(LockType.READ)
public class DAO {

	@PersistenceContext(unitName = "ct")
	protected EntityManager em;

	public <E> E create(E e) {
		em.persist(e);
		em.flush();
		return e;
	}

	public <E> E update(E e) {
		E suck = em.merge(e);
		em.flush();

		return suck;
	}

	public <E> void delete(Class<E> clazz, int id) {
		em.remove(em.find(clazz, id));
		em.flush();
	}

	public <E> void delete(Class<E> clazz, long id) {
		em.remove(em.find(clazz, id));
	}

	public <E> E find(Class<E> clazz, int id) {
		return em.find(clazz, id);
	}

	public <E> E find(Class<E> clazz, long id) {
		return em.find(clazz, id);
	}

	public <E> List<E> find(Class<E> clazz, String query, String bindName,
			int bindValue) {
		Query localQuery = em.createQuery(query);
		localQuery.setParameter(bindName, bindValue);

		return localQuery.getResultList();
	}

	public <E> List<E> find(Class<E> clazz, String query, String bindName,
			String bindValue) {
		Query localQuery = em.createQuery(query);
		localQuery.setParameter(bindName, bindValue);

		return localQuery.getResultList();
	}

	public <E> List<E> find(Class<E> clazz, String query, String bindNameOne,
			int bindValueOne, String bindNameTwo, String bindValueTwo) {
		Query localQuery = em.createQuery(query);
		localQuery.setParameter(bindNameOne, bindValueOne);
		localQuery.setParameter(bindNameTwo, bindValueTwo);

		return localQuery.getResultList();
	}

	public <E> List<E> find(Class<E> clazz, String query, int min, int max) {
		return queryRange(em.createQuery(query, clazz), min, max)
				.getResultList();
	}

	public <E> List<E> namedFind(Class<E> clazz, String query, int min,
			int max) {
		return queryRange(em.createNamedQuery(query, clazz), min, max)
				.getResultList();
	}

	public List<Object[]> findStudyCounts(int studyId, String status) {

		Query query = em.createQuery(
				"SELECT p.study.shortName , COUNT(p), p.study.studyEnrollmentGoal  FROM Patient p where p.study.studyId = :studyId and p.status= :status");

		query.setParameter("studyId", studyId);
		query.setParameter("status", status);

		return query.getResultList();

	}

	public List<Object[]> findDocCounts(int studyId) {

		Query query = em.createQuery(
				"SELECT p.study.shortName , COUNT(p), p.study.studyEnrollmentGoal  FROM Patient p where p.study.studyId = :studyId and p.status= :status");

		query.setParameter("studyId", studyId);

		return query.getResultList();

	}

	public List<Object[]> findSiteStudyCounts(int siteId, String status) {

		String queryString = null;

		if (status.equalsIgnoreCase("all")) {
			queryString = "Select count(sc),  sc.study_name, sc.patient_status, sc.siteId from SiteCounts sc where sc.siteId = :siteId group by sc.study_name, sc.patient_status order by count(sc) desc";
		} else {
			queryString = "Select count(sc),  sc.study_name, sc.patient_status, sc.siteId from SiteCounts sc where sc.siteId = :siteId and sc.patient_status = :status group by sc.study_name, sc.patient_status order by count(sc) desc";
		}

		Query query = em.createQuery(queryString);

		if (status.equalsIgnoreCase("all")) {
			query.setParameter("siteId", siteId);
		} else {
			query.setParameter("siteId", siteId);
			query.setParameter("status", status);
		}

		return query.getResultList();

	}

	private static Query queryRange(Query query, int min, int max) {
		if (max >= 0) {
			query.setMaxResults(max);
		}
		if (min >= 0) {
			query.setFirstResult(min);
		}
		return query;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
