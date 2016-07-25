package com.halehan.ct.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.halehan.ct.model.CodeTables;

@XmlRootElement(name = "codetables")
public class CodeTablesVo {

	private int codeTableId;

	private String codeTableName;

	private String codeTableKey;

	private String codeTableValue;

	public void copyCodeTables(CodeTables codeTables) {
		this.codeTableId = codeTables.getCodeTableId();
		this.codeTableKey = codeTables.getCodeTableKey();
		this.codeTableName = codeTables.getCodeTableName();
		this.codeTableValue = codeTables.getCodeTableValue();
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
