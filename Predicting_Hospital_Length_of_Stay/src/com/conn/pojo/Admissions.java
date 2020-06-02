package com.conn.pojo;

import java.sql.Date;

public class Admissions {

	private long id;
	private long subject_id;
	private long hadm_id;
	private Date admittime;
	private Date dischtime;
	private Date deathtime;
	private String admission_type;
	private String admission_location;
	private String discharge_location;
	private String insurance;
	private String language;
	private String religion;
	private String marital_status;
	private String ethnicity;
	private String diagnosis;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}

	public long getHadm_id() {
		return hadm_id;
	}

	public void setHadm_id(long hadm_id) {
		this.hadm_id = hadm_id;
	}

	public Date getAdmittime() {
		return admittime;
	}

	public void setAdmittime(Date admittime) {
		this.admittime = admittime;
	}

	public Date getDischtime() {
		return dischtime;
	}

	public void setDischtime(Date dischtime) {
		this.dischtime = dischtime;
	}

	public Date getDeathtime() {
		return deathtime;
	}

	public void setDeathtime(Date deathtime) {
		this.deathtime = deathtime;
	}

	public String getAdmission_type() {
		return admission_type;
	}

	public void setAdmission_type(String admission_type) {
		this.admission_type = admission_type;
	}

	public String getAdmission_location() {
		return admission_location;
	}

	public void setAdmission_location(String admission_location) {
		this.admission_location = admission_location;
	}

	public String getDischarge_location() {
		return discharge_location;
	}

	public void setDischarge_location(String discharge_location) {
		this.discharge_location = discharge_location;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

}