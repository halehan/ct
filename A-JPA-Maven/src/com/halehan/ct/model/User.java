package com.halehan.ct.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Cache(size = 12000, expiry = 5000)
@Table(name = "user", schema = "ct")

@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findBySite", query = "SELECT u FROM User u where u.site.siteId = :siteid")})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userId;

	private String fname;

	private String lname;

	private String loginId;

	private String password;

	private String phone;

	private String email;

	// bi-directional many-to-one association to StudyDeviation
	@OneToMany(mappedBy = "user")
	private List<StudyDeviation> studyDeviations1;

	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;

	// bi-directional many-to-one association to Patient
	@OneToMany(mappedBy = "technician")
	private List<Patient> patients1;

	// bi-directional many-to-one association to Patient
	@OneToMany(mappedBy = "doctor")
	private List<Patient> patients2;

	@ManyToOne
	@JoinColumn(name = "siteId")
	private Site site;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<StudyDeviation> getStudyDeviations1() {
		return studyDeviations1;
	}

	public void setStudyDeviations1(List<StudyDeviation> studyDeviations1) {
		this.studyDeviations1 = studyDeviations1;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * public List<StudyDeviation> getStudyDeviations2() { return
	 * studyDeviations2; }
	 * 
	 * public void setStudyDeviations2(List<StudyDeviation> studyDeviations2) {
	 * this.studyDeviations2 = studyDeviations2; }
	 */
}