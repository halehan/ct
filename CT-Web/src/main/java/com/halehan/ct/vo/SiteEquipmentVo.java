package com.halehan.ct.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.SiteEquipment;

@XmlRootElement(name = "siteEquipment")
public class SiteEquipmentVo {

	private int site_equipmentId;
	private String manufacturer;
	private String name;
	private String serialNumber;
	private String type;
	private String location;

	public void copySiteEquipment(SiteEquipment siteEquipment) {

		this.site_equipmentId = siteEquipment.getSite_equipmentId();
		this.manufacturer = siteEquipment.getManufacturer();
		this.name = siteEquipment.getName();
		this.serialNumber = siteEquipment.getSerialNumber();
		this.type = siteEquipment.getType();
		this.location = siteEquipment.getLocation();

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

	public int getSite_equipmentId() {
		return site_equipmentId;
	}

	public void setSite_equipmentId(int site_equipmentId) {
		this.site_equipmentId = site_equipmentId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
