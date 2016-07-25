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

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.halehan.ct.model.CodeTables;
import com.halehan.ct.model.Role;

@Stateless
public class CodeTableDAO {

	@EJB
	private DAO dao;

	public List<CodeTables> listAll(int first, int max) {

		return dao.namedFind(CodeTables.class, "CodeTables.findAll", first,
				max);

	}

	public List<CodeTables> findByCodeName(String codeTableName) {

		return dao.find(CodeTables.class,
				"SELECT ct FROM CodeTables ct WHERE ct.codeTableName = :codeTableName",
				"codeTableName", codeTableName);

	}

	public List<Role> listAllRoles(int first, int max) {

		return dao.namedFind(Role.class, "Role.findAll", first, max);

	}

}
