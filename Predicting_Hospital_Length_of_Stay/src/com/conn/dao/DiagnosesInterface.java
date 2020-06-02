package com.conn.dao;

import java.util.List;

import com.conn.pojo.Diagnoses;

public interface DiagnosesInterface {

	public boolean save(Diagnoses Diagnoses);

	public List<Diagnoses> DiagnosesList();

	public boolean updateDiagnoses(Diagnoses Diagnoses);

	public boolean editDiagnoses(Diagnoses Diagnoses);

	public boolean deleteDiagnoses(Diagnoses Diagnoses);

	public Diagnoses getElementById(Diagnoses Diagnoses);

}
