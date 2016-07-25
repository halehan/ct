package com.halehan.ct.vo.charts;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chart")
public class DoctorStudyChartVo {

	private String doctor;
	private String count;
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

}
