package com.halehan.ct.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.halehan.ct.dao.GraphDAO;
import com.halehan.ct.dao.SiteDAO;
import com.halehan.ct.model.SiteCounts;
import com.halehan.ct.vo.DeviationsVo;
import com.halehan.ct.vo.SiteCountsVo;
import com.halehan.ct.vo.SiteVo;
import com.halehan.ct.vo.charts.DocCountsVo;

@Path("/site")
@Produces({"application/json"})
public class SiteService {

	@EJB
	private SiteDAO siteDao;
	@EJB
	private GraphDAO graphDao;

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SiteVo> listAll() {

		return siteDao.findAll();

	}

	@Path("/list/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SiteVo listBySite(@PathParam("id") String id) {

		return siteDao.findSiteVo(Integer.parseInt(id));

	}

	@Path("/list/chart/{id}")
	@GET
	public List<SiteCountsVo> siteCounts(@PathParam("id") int id) {

		List<SiteCounts> counts = siteDao.findSiteCounts(id);
		List<SiteCountsVo> countsVo = new ArrayList<SiteCountsVo>();

		for (SiteCounts val : counts) {
			SiteCountsVo siteCount = new SiteCountsVo();
			siteCount.copySiteCounts(val);

			countsVo.add(siteCount);
		}

		return countsVo;

	}

	@Path("/list/study/chart/{id}/{status}")
	@GET
	public List<SiteCountsVo> siteStudyCounts(@PathParam("id") int id,
			@PathParam("status") String status) {

		List<SiteCountsVo> counts = siteDao.findSiteStudyCounts(id, status);

		return counts;

	}

	@Path("/doccounts/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DocCountsVo> listDocBySite(@PathParam("id") int id) {

		return graphDao.findSiteDocCounts(id);

	}

	@Path("/deviationcounts/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DeviationsVo> listDeviationsBySite(@PathParam("id") int id) {

		return graphDao.findSiteDeviationCounts(id);

	}

	@Path("/deviationusercounts/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DeviationsVo> listDeviationsByUser(@PathParam("id") int id) {

		return graphDao.findSiteUserDeviationCounts(id);

	}

}
