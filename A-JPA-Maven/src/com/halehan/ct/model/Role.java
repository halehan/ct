package com.halehan.ct.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4125684612764992682L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;

	private String roleAccess;

	private String roleDescription;

	private String roleName;

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "role")
	private List<User> users;

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleAccess() {
		return this.roleAccess;
	}

	public void setRoleAccess(String roleAccess) {
		this.roleAccess = roleAccess;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}