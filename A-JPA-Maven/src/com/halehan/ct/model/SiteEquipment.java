package com.halehan.ct.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the site_equipment database table.
 * 
 */
@Entity
@Table(name = "site_equipment")
@NamedQuery(name = "SiteEquipment.findAll", query = "SELECT s FROM SiteEquipment s")
public class SiteEquipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int site_equipmentId;

	private String manufacturer;

	private String name;

	@Column(name = "serial_number")
	private String serialNumber;

	private String type;
	private String location;

	// bi-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name = "siteId")
	private Site site;

	public SiteEquipment() {
	}

	public int getSite_equipmentId() {
		return this.site_equipmentId;
	}

	public void setSite_equipmentId(int site_equipmentId) {
		this.site_equipmentId = site_equipmentId;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
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