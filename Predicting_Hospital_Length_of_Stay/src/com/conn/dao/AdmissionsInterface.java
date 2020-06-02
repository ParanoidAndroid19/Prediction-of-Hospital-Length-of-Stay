package com.conn.dao;

import java.util.List;

import com.conn.pojo.Admissions;
import com.conn.pojo.Patients;

public interface AdmissionsInterface {

	public boolean save(Admissions Admissions);

	public List<Admissions> AdmissionsList();

	public boolean updateAdmissions(Admissions Admissions);

	public boolean editAdmissions(Admissions Admissions);

	public boolean deleteAdmissions(Admissions Admissions);

	public Admissions getElementById(Long id);
	
	public Object[] getDataForLos(List<Long> hadmIds);

}
