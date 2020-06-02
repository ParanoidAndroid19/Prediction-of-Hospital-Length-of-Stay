package com.conn.pojo;

import java.sql.Date;

public class Diagnoses {

	private long id;
	private String icd9_code;
	private String short_title;
	private String long_title;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIcd9_code() {
		return icd9_code;
	}

	public void setIcd9_code(String icd9_code) {
		this.icd9_code = icd9_code;
	}

	public String getShort_title() {
		return short_title;
	}

	public void setShort_title(String short_title) {
		this.short_title = short_title;
	}

	public String getLong_title() {
		return long_title;
	}

	public void setLong_title(String long_title) {
		this.long_title = long_title;
	}

}