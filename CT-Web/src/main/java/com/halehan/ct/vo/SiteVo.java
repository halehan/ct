package com.halehan.ct.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.Site;
import com.halehan.ct.model.SiteEquipment;
import com.halehan.ct.model.User;

@XmlRootElement(name = "site")
public class SiteVo {

	private int siteId;
	private int practiceId;

	private String name;
	private String abbreviatedName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	List<SiteEquipmentVo> siteEquipmentVoList = new ArrayList<SiteEquipmentVo>();
	List<UserVo> userVoList = new ArrayList<UserVo>();

	public void copySite(Site site) {

		this.siteId = site.getSiteId();
		this.practiceId = site.getPractice().getPracticeId();
		this.name = site.getName();
		this.abbreviatedName = site.getAbbreviatedName();
		this.address = site.getAddress();
		this.city = site.getCity();
		this.state = site.getState();
		this.zip = site.getZip();
	}

	public void copySiteEquipment(List<SiteEquipment> siteEquipment) {

		for (SiteEquipment val : siteEquipment) {
			SiteEquipmentVo siteEquipmentVo = new SiteEquipmentVo();
			siteEquipmentVo.copySiteEquipment(val);
			siteEquipmentVoList.add(siteEquipmentVo);
		}

	}

	public void copySiteUser(List<User> siteUsers) {

		for (User val : siteUsers) {
			val.getRole().getRoleName();
			UserVo userVo = new UserVo();
			userVo.copyUser(val);
			userVoList.add(userVo);
		}

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

	public int getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(int practiceId) {
		this.practiceId = practiceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviatedName() {
		return abbreviatedName;
	}

	public void setAbbreviatedName(String abbreviatedName) {
		this.abbreviatedName = abbreviatedName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public List<SiteEquipmentVo> getSiteEquipmentVoList() {
		return siteEquipmentVoList;
	}

	public void setSiteEquipmentVoList(
			List<SiteEquipmentVo> siteEquipmentVoList) {
		this.siteEquipmentVoList = siteEquipmentVoList;
	}

	public List<UserVo> getUserVoList() {
		return userVoList;
	}

	public void setUserVoList(List<UserVo> userVoList) {
		this.userVoList = userVoList;
	}

}
