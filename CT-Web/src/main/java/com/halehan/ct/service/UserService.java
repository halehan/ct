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

import com.halehan.ct.dao.UserDAO;
import com.halehan.ct.model.User;
import com.halehan.ct.view.StudyList;
import com.halehan.ct.vo.UserVo;

@Path("/user")
@Produces({"application/json"})
public class UserService {

	@EJB
	private UserDAO userDao;

	List<StudyList> studyVals = null;

	@Path("{id}")
	@GET
	public UserVo findUser(@PathParam("id") String id) {

		User user = userDao.find(Integer.parseInt(id));

		UserVo userVo = new UserVo();
		userVo.copyUser(user);

		return userVo;

	}

	@Path("/site/{id}")
	@GET
	public List<UserVo> findUserBySite(@PathParam("id") String id) {

		List<User> userList = userDao.findBySite(Integer.parseInt(id));
		ArrayList<UserVo> userVoList = new ArrayList<UserVo>();

		for (User user : userList) {

			UserVo userVo = new UserVo();
			userVo.copyUser(user);
			userVoList.add(userVo);

		}

		return userVoList;

	}

	@GET
	public List<UserVo> find() {

		List<User> userList = userDao.listAll(0, 100);
		ArrayList<UserVo> userVoList = new ArrayList<UserVo>();

		for (User user : userList) {

			UserVo userVo = new UserVo();
			userVo.copyUser(user);
			userVoList.add(userVo);

		}

		return userVoList;
	}

	@DELETE
	@Path("{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public String remove(@PathParam("id") int id) {

		userDao.delete(id);

		return "ok";

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String update(UserVo vo) {

		userDao.update(vo);

		System.out
				.println("Just updated " + vo.getFname() + " " + vo.getLname());

		return "ok";

	}

	@Path("/user")
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

		userDao.create(user);

		System.out.println(
				"Just inserted " + vo.getFname() + "  " + vo.getLname());

		return "ok";

	}

}
