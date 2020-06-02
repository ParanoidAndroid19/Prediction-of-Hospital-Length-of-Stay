package com.conn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.xpath.GetPathTest;

import com.conn.pojo.Patients;
import com.login.utility.MyConnection;

public class PatientsDaoImpl implements PatientsInterface {

	//Connection conn = null;

	public long save(Patients patients) {
		Connection conn =  null;
		try {
			long currentTime = System.currentTimeMillis();
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("insert into patients(patient_name,age,gender,dob,dod,dod_hosp,dod_ssn,expire_flag,current_t,new) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, patients.getPatient_name());
			ps.setInt(2, patients.getAge());
			ps.setString(3, patients.getGender());
			ps.setDate(4, patients.getDob());
			ps.setDate(5, patients.getDod());
			ps.setDate(6, patients.getDod_hosp());
			ps.setDate(7, patients.getDod_ssn());
			ps.setString(8, patients.getExpire_flag());
			ps.setLong(9, currentTime);
			ps.setInt(10,1);
			int no = ps.executeUpdate();
			if (no > 0) {
				System.out.println("current time " + currentTime);
				long id = getElementByCurrentTime(currentTime);
				System.out.println("id " + id);
				updatePatientSubjectId(id);
				return id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0L;
	}

	private long getElementByCurrentTime(long currentTime) {
		Connection conn = null;
		try {
			conn = MyConnection.getConnectionObj();	
			PreparedStatement ps = conn
					.prepareStatement("select * from patients where current_t=? ");
			ps.setLong(1, currentTime);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getLong("id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}	

	public boolean updatePatientSubjectId(long id) {
		Connection conn = null;
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("update patients set subject_id=? where  id=? ");
			
			ps.setLong(1, id);
			ps.setLong(2, id);
			int no = ps.executeUpdate();
			if (no > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updatePatients(Patients Patients) {
		Connection conn = null;
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("update patients set subject_id=?,gender=?,dob=?,dod=?,dod_hosp=?,dod_ssn=?,expire_flag=? where  id=? ");
			
			ps.setLong(1, Patients.getSubject_id());
			ps.setString(2, Patients.getGender());
			ps.setDate(3, Patients.getDob());
			ps.setDate(4, Patients.getDod());
			ps.setDate(5, Patients.getDod_hosp());
			ps.setDate(6, Patients.getDod_ssn());
			ps.setString(7, Patients.getExpire_flag());
			ps.setLong(8, Patients.getId());
			int no = ps.executeUpdate();
			if (no > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Patients> patientsList() {
		Connection conn = null;
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from patients where new=1");
			ResultSet rs = ps.executeQuery();
			List<Patients> patientsList = new ArrayList<Patients>();
			
			while (rs.next()) {
				Patients patients = new Patients();
				patients.setId(rs.getLong("id"));
				patients.setPatient_name(rs.getString("patient_name"));
				patients.setAge(rs.getInt("age"));
				patients.setSubject_id(rs.getLong("subject_id"));
				patients.setGender(rs.getString("gender"));
				patients.setDob(rs.getDate("dob"));
				//patients.setDod(rs.getDate("dod"));
				//patients.setDod_hosp(rs.getDate("dod_hosp"));
				patients.setDod_ssn(rs.getDate("dod_ssn"));
				//patients.setExpire_flag(rs.getString("expire_flag"));
				patientsList.add(patients);
			}
			return patientsList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	public Patients getElementById(Long subjectid) {
		Connection conn = null;
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from patients where subject_id=?");
			ps.setLong(1, subjectid);
            Patients patients = new Patients();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				patients.setPatient_name(rs.getString("patient_name"));
				patients.setAge(rs.getInt("age"));
				patients.setId(rs.getLong("id"));
				patients.setSubject_id(rs.getLong("subject_id"));
				patients.setGender(rs.getString("gender"));
				//patients.setDob(rs.getDate("dob"));
				//patients.setDod(rs.getDate("dod"));
				//patients.setDod_hosp(rs.getDate("dod_hosp"));
				//patients.setDod_ssn(rs.getDate("dod_ssn"));
				//patients.setExpire_flag(rs.getString("expire_flag"));
				
			}
			return patients;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean editPatients(Patients Patients) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatients(Patients Patients) {
		Connection conn = null;
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("delete  from patients where id=? ");
			ps.setLong(1, Patients.getId());
			return ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}