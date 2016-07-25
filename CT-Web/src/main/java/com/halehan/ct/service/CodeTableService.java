package com.halehan.ct.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.halehan.ct.dao.CodeTableDAO;
import com.halehan.ct.dao.MiscDAO;
import com.halehan.ct.model.CodeTables;
import com.halehan.ct.model.Role;
import com.halehan.ct.model.User;
import com.halehan.ct.view.StudyList;
import com.halehan.ct.vo.CodeTablesVo;
import com.halehan.ct.vo.RolesVo;
import com.halehan.ct.vo.UserVo;

@Path("/codes")
@Produces({"application/json"})
public class CodeTableService {

	@EJB
	private CodeTableDAO codeTableDAO;
	@EJB
	private MiscDAO miscDAO;

	List<StudyList> studyVals = null;

	@Path("{name}")
	@GET
	public List<CodeTablesVo> findUser(@PathParam("name") String name) {

		List<CodeTables> codeTablesList = codeTableDAO.findByCodeName(name);
		List<CodeTablesVo> codeTableVoList = new ArrayList<CodeTablesVo>();

		for (CodeTables code : codeTablesList) {
			CodeTablesVo codeTable = new CodeTablesVo();
			codeTable.copyCodeTables(code);
			codeTableVoList.add(codeTable);
		}

		return codeTableVoList;

	}

	@GET
	public List<CodeTablesVo> findAll() {

		List<CodeTables> codeTablesList = codeTableDAO.listAll(0, 100);
		List<CodeTablesVo> codeTableVoList = new ArrayList<CodeTablesVo>();

		for (CodeTables code : codeTablesList) {
			CodeTablesVo codeTable = new CodeTablesVo();
			codeTable.copyCodeTables(code);
			codeTableVoList.add(codeTable);
		}

		return codeTableVoList;

	}

	@Path("/roles")
	@GET
	public List<RolesVo> findRoles(@PathParam("name") String name) {

		List<Role> roleList = miscDAO.roleList(0, 25);
		List<RolesVo> roleVoList = new ArrayList<RolesVo>();

		for (Role role : roleList) {
			RolesVo rolesVo = new RolesVo();
			rolesVo.copyRoles(role);

			roleVoList.add(rolesVo);
		}

		return roleVoList;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String update(UserVo vo) {

		// codeTableDAO.update(vo);

		System.out
				.println("Just updated " + vo.getFname() + " " + vo.getLname());

		return "ok";

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String create(UserVo vo) {

		User user = new User();

		user.setFname(vo.getFname());
		user.setLname(vo.getLname());
		user.setLoginId(vo.getLogin());
		user.setEmail(vo.getEmail());
		user.setPhone(vo.getPhone());

		// codeTableDAO.create(user);

		System.out.println(
				"Just inserted " + vo.getFname() + "  " + vo.getLname());

		return "ok";

	}

}
