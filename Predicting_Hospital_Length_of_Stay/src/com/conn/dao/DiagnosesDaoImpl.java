package com.conn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.conn.pojo.Admissions;
import com.conn.pojo.Diagnoses;
import com.login.utility.MyConnection;

public class DiagnosesDaoImpl implements DiagnosesInterface {

	Connection conn = null;

	public boolean save(Diagnoses Diagnoses) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("insert into d_icd_diagnoses(,id,icd9_code,short_title,long_title) values (,?,?,?,?)");
			ps.setLong(0, Diagnoses.getId());
			ps.setString(1, Diagnoses.getIcd9_code());
			ps.setString(2, Diagnoses.getShort_title());
			ps.setString(3, Diagnoses.getLong_title());
			int no = ps.executeUpdate();
			if (no > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateDiagnoses(Diagnoses Diagnoses) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("update d_icd_diagnoses set icd9_code=?,short_title=?,long_title=? where  id=? ");
			ps.setLong(0, Diagnoses.getId());
			ps.setString(1, Diagnoses.getIcd9_code());
			ps.setString(2, Diagnoses.getShort_title());
			ps.setString(3, Diagnoses.getLong_title());
			int no = ps.executeUpdate();
			if (no > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Diagnoses> DiagnosesList() {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from d_icd_diagnoses ");
			ResultSet rs = ps.executeQuery();
			List<Diagnoses> DiagnosesList = new ArrayList<Diagnoses>();
			Diagnoses Diagnoses = new Diagnoses();
			while (rs.next()) {
				Diagnoses.setId(rs.getLong("id"));
				Diagnoses.setIcd9_code(rs.getString("icd9_code"));
				Diagnoses.setShort_title(rs.getString("short_title"));
				Diagnoses.setLong_title(rs.getString("long_title"));
				DiagnosesList.add(Diagnoses);
			}
			return DiagnosesList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Diagnoses getElementById(Diagnoses Diagnoses) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from d_icd_diagnoses where id=?");
			ps.setLong(1, Diagnoses.getId());
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Diagnoses.setId(rs.getLong("id"));
				Diagnoses.setIcd9_code(rs.getString("icd9_code"));
				Diagnoses.setShort_title(rs.getString("short_title"));
				Diagnoses.setLong_title(rs.getString("long_title"));
				Diagnoses.setId(rs.getLong("id"));
				Diagnoses.setIcd9_code(rs.getString("icd9_code"));
				Diagnoses.setShort_title(rs.getString("short_title"));
				Diagnoses.setLong_title(rs.getString("long_title"));
			}
			return Diagnoses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean editDiagnoses(Diagnoses Diagnoses) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDiagnoses(Diagnoses Diagnoses) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("delete  from admissions where id=? ");
			ps.setLong(1, Diagnoses.getId());
			return ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}