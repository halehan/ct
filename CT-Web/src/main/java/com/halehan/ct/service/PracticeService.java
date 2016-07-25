package com.halehan.ct.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.halehan.ct.dao.GraphDAO;
import com.halehan.ct.dao.PracticeDAO;
import com.halehan.ct.vo.PracticeVo;
import com.halehan.ct.vo.SiteCountsVo;

@Path("/practice")
@Produces({"application/json"})
public class PracticeService {

	@EJB
	private PracticeDAO practiceDao;
	@EJB
	private GraphDAO graphDao;

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PracticeVo> listAll() {

		return practiceDao.findAll();

	}

	@Path("/list/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PracticeVo listByPractice(@PathParam("id") int id) {

		System.out.println("Id = " + id);
		return practiceDao.findPractice(id);

	}

	@Path("/list/chart/{id}/{status}")
	@GET
	public List<SiteCountsVo> siteStudyCounts(@PathParam("id") int id,
			@PathParam("status") String status) {

		List<SiteCountsVo> counts = graphDao.findPracticeStudyCounts(id,
				status);

		return counts;

	}

}
