package com.halehan.ct.vo.charts;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "doccounts")
public class DocCountsVo {

	private String name;
	private int count;

	private String toString(Date date) {

		String rtnStringDate = "";

		if (!(date == null)) {

			String DATE_FORMAT = "MM/dd/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

			rtnStringDate = sdf.format(date);

		}

		return rtnStringDate;

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
