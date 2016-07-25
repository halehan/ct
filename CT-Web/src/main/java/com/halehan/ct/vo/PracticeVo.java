package com.halehan.ct.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.Practice;

@XmlRootElement(name = "practice")
public class PracticeVo {

	private int practiceId;

	private String name;
	private String abbreviatedName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private List<SiteVo> sites;

	public void copyPractice(Practice practice) {

		this.practiceId = practice.getPracticeId();
		this.name = practice.getName();
		this.abbreviatedName = practice.getAbbreviatedName();
		this.address = practice.getAddress();
		this.city = practice.getCity();
		this.state = practice.getState();
		this.zip = practice.getZip();
		this.phone = practice.getPhone();

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

	public List<SiteVo> getSites() {
		return sites;
	}

	public void setSites(List<SiteVo> sites) {
		this.sites = sites;
	}

}
