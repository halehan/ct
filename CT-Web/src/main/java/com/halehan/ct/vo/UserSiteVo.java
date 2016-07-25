package com.halehan.ct.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.Site;
import com.halehan.ct.model.User;

@XmlRootElement(name = "userSite")
public class UserSiteVo {

	private SiteVo siteVo;
	private UserVo userVo;

	public void copySite(Site site) {
		this.siteVo = new SiteVo();
		this.siteVo.copySite(site);

	}

	public void copyUser(User user) {

		this.userVo = new UserVo();
		this.userVo.copyUser(user);

	}

	private String toString(Date date) {

		String rtnStringDate = "";

		if (!(date == null)) {

			String DATE_FORMAT = "MM/dd/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

			rtnStringDate = sdf.format(date);

		}

		return rtnStringDate;

	}

	public SiteVo getSiteVo() {
		return siteVo;
	}

	public void setSiteVo(SiteVo siteVo) {
		this.siteVo = siteVo;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}

}
