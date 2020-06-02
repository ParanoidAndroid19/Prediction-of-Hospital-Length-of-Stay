package com.conn.dao;


import java.util.List;

import com.conn.pojo.Patients;

public interface PatientsInterface {
	
	public long save(Patients Patients);
public List<Patients> patientsList();
public boolean updatePatients (Patients Patients);
public boolean editPatients (Patients Patients);
public boolean deletePatients (Patients Patients);
public Patients getElementById(Long subjectid);


}



