package com.halehan.ct.vo.charts;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chart")
public class StudyEnrollment {

	private String count;
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

}
