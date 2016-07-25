package com.halehan.ct.service;

import java.util.ArrayList;
import java.util.List;

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

import com.halehan.ct.dao.MiscDAO;
import com.halehan.ct.model.SiteEquipment;
import com.halehan.ct.model.User;
import com.halehan.ct.view.StudyList;
import com.halehan.ct.vo.SiteEquipmentVo;
import com.halehan.ct.vo.UserVo;

@Path("/equipment")
@Produces({"application/json"})
public class MaintenanceService {

	@EJB
	private MiscDAO miscDAO;

	List<StudyList> studyVals = null;

	@Path("{id}")
	@GET
	public SiteEquipmentVo findSiteEquipment(@PathParam("id") int id) {

		SiteEquipment siteEquipment = miscDAO.findSiteEquipmentById(id);

		SiteEquipmentVo vo = new SiteEquipmentVo();

		vo.copySiteEquipment(siteEquipment);

		return vo;

	}

	@DELETE
	@Path("{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public String remove(@PathParam("id") int id) {

		miscDAO.deleteEquipment(id);

		return "ok";

	}

	@Path("/site/{id}")
	@GET
	public List<SiteEquipmentVo> findBySite(@PathParam("id") int id) {

		List<SiteEquipment> equipmentList = miscDAO.findSiteEquipmentBySite(id);

		List<SiteEquipmentVo> list = new ArrayList<SiteEquipmentVo>();

		for (SiteEquipment val : equipmentList) {
			SiteEquipmentVo vo = new SiteEquipmentVo();

			vo.copySiteEquipment(val);
			list.add(vo);

		}

		return list;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String update(SiteEquipmentVo vo) {

		miscDAO.update(vo);

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
