package com.halehan.ct.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Cache(size = 12000, expiry = 4000)
@Table(name = "code_tables", schema = "ct")
@NamedQuery(name = "CodeTables.findAll", query = "SELECT ct FROM CodeTables ct")
public class CodeTables implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8408944941996759070L;

	@Id
	private int codeTableId;

	private String codeTableName;

	private String codeTableKey;

	private String codeTableValue;

	public int getCodeTableId() {
		return codeTableId;
	}

	public void setCodeTableId(int codeTableId) {
		this.codeTableId = codeTableId;
	}

	public String getCodeTableName() {
		return codeTableName;
	}

	public void setCodeTableName(String codeTableName) {
		this.codeTableName = codeTableName;
	}

	public String getCodeTableKey() {
		return codeTableKey;
	}

	public void setCodeTableKey(String codeTableKey) {
		this.codeTableKey = codeTableKey;
	}

	public String getCodeTableValue() {
		return codeTableValue;
	}

	public void setCodeTableValue(String codeTableValue) {
		this.codeTableValue = codeTableValue;
	}

}