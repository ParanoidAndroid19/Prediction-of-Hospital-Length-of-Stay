package com.conn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conn.pojo.Admissions;
import com.conn.pojo.Patients;
import com.login.utility.MyConnection;

public class AdmissionsDaoImpl implements AdmissionsInterface {

	Connection conn = null;

	public boolean save(Admissions Admissions) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("insert into admissions(subject_id,hadm_id,admittime,dischtime,deathtime,admission_type,admission_location,discharge_location,insurance,language,religion,marital_status,ethnicity,diagnosis) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, Admissions.getSubject_id());
			ps.setLong(2, Admissions.getHadm_id());
			ps.setDate(3, Admissions.getAdmittime());
			ps.setDate(4, Admissions.getDischtime());
			ps.setDate(5, Admissions.getDeathtime());
			ps.setString(6, Admissions.getAdmission_type());
			ps.setString(7, Admissions.getAdmission_location());
			ps.setString(8, Admissions.getDischarge_location());
			ps.setString(9, Admissions.getInsurance());
			ps.setString(10, Admissions.getLanguage());
			ps.setString(11, Admissions.getReligion());
			ps.setString(12, Admissions.getMarital_status());
			ps.setString(13, Admissions.getEthnicity());
			ps.setString(14, Admissions.getDiagnosis());
			int no = ps.executeUpdate();
			if (no > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateAdmissions(Admissions Admissions) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("update admissions set subject_id=?,hadm_id=?,admittime=?,dischtime=?,deathtime=?,admission_type=?,admission_location=?,discharge_location=?,insurance=?,language=?,religion=?,marital_status=?,ethnicity=?,diagnosis=? where  id=? ");
			
			ps.setLong(1, Admissions.getSubject_id());
			ps.setLong(2, Admissions.getHadm_id());
			ps.setDate(3, Admissions.getAdmittime());
			ps.setDate(4, Admissions.getDischtime());
			ps.setDate(5, Admissions.getDeathtime());
			ps.setString(6, Admissions.getAdmission_type());
			ps.setString(7, Admissions.getAdmission_location());
			ps.setString(8, Admissions.getDischarge_location());
			ps.setString(9, Admissions.getInsurance());
			ps.setString(10, Admissions.getLanguage());
			ps.setString(11, Admissions.getReligion());
			ps.setString(12, Admissions.getMarital_status());
			ps.setString(13, Admissions.getEthnicity());
			ps.setString(14, Admissions.getDiagnosis());
			ps.setLong(15, Admissions.getId());
			int no = ps.executeUpdate();
			if (no > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Admissions> AdmissionsList() {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from admissions ");
			ResultSet rs = ps.executeQuery();
			List<Admissions> AdmissionsList = new ArrayList<Admissions>();
			
			while (rs.next()) {
				Admissions Admissions = new Admissions();
				Admissions.setId(rs.getLong("id"));
				Admissions.setSubject_id(rs.getLong("subject_id"));
				Admissions.setHadm_id(rs.getLong("hadm_id"));
				Admissions.setAdmittime(rs.getDate("admittime"));
				Admissions.setDischtime(rs.getDate("dischtime"));
				Admissions.setDeathtime(rs.getDate("deathtime"));
				Admissions.setAdmission_type(rs.getString("admission_type"));
				Admissions.setAdmission_location(rs
						.getString("admission_location"));
				Admissions.setDischarge_location(rs
						.getString("discharge_location"));
				Admissions.setInsurance(rs.getString("insurance"));
				Admissions.setLanguage(rs.getString("language"));
				Admissions.setReligion(rs.getString("religion"));
				Admissions.setMarital_status(rs.getString("marital_status"));
				Admissions.setEthnicity(rs.getString("ethnicity"));
				Admissions.setDiagnosis(rs.getString("diagnosis"));
				AdmissionsList.add(Admissions);
			}
			return AdmissionsList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Admissions getElementById(Long id) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from admissions where id=?");
			ps.setLong(1, id);
			
			Admissions admissions = new Admissions();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				admissions.setId(rs.getLong("id"));
				admissions.setSubject_id(rs.getLong("subject_id"));
				admissions.setHadm_id(rs.getLong("hadm_id"));
				//Admissions.setAdmittime(rs.getDate("admittime"));
				//Admissions.setDischtime(rs.getDate("dischtime"));
				//Admissions.setDeathtime(rs.getDate("deathtime"));
				admissions.setAdmission_type(rs.getString("admission_type"));
				//Admissions.setAdmission_location(rs
						//.getString("admission_location"));
				//Admissions.setDischarge_location(rs
					//	.getString("discharge_location"));
				//Admissions.setInsurance(rs.getString("insurance"));
				//Admissions.setLanguage(rs.getString("language"));
				//Admissions.setReligion(rs.getString("religion"));
				admissions.setMarital_status(rs.getString("marital_status"));
				//Admissions.setEthnicity(rs.getString("ethnicity"));
				//Admissions.setDiagnosis(rs.getString("diagnosis"));
				admissions.setId(rs.getLong("id"));
				admissions.setSubject_id(rs.getLong("subject_id"));
				admissions.setHadm_id(rs.getLong("hadm_id"));
				//Admissions.setAdmittime(rs.getDate("admittime"));
				//Admissions.setDischtime(rs.getDate("dischtime"));
				//Admissions.setDeathtime(rs.getDate("deathtime"));
				//Admissions.setAdmission_type(rs.getString("admission_type"));
				//Admissions.setAdmission_location(rs
					//	.getString("admission_location"));
				//Admissions.setDischarge_location(rs
					//	.getString("discharge_location"));
				//Admissions.setInsurance(rs.getString("insurance"));
				//Admissions.setLanguage(rs.getString("language"));
				//Admissions.setReligion(rs.getString("religion"));
				admissions.setMarital_status(rs.getString("marital_status"));
				//Admissions.setEthnicity(rs.getString("ethnicity"));
				//Admissions.setDiagnosis(rs.getString("diagnosis"));
			}
			return admissions;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Admissions getElementBySubjectId(Long subjectid) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from admissions where subject_id=?");
			ps.setLong(1,subjectid);
			
			Admissions admissions = new Admissions();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				admissions.setId(rs.getLong("id"));
				admissions.setSubject_id(rs.getLong("subject_id"));
				admissions.setHadm_id(rs.getLong("hadm_id"));
				//Admissions.setAdmittime(rs.getDate("admittime"));
				//Admissions.setDischtime(rs.getDate("dischtime"));
				//Admissions.setDeathtime(rs.getDate("deathtime"));
				//Admissions.setAdmission_type(rs.getString("admission_type"));
				//Admissions.setAdmission_location(rs
						//.getString("admission_location"));
				//Admissions.setDischarge_location(rs
					//	.getString("discharge_location"));
				//Admissions.setInsurance(rs.getString("insurance"));
				//Admissions.setLanguage(rs.getString("language"));
				//Admissions.setReligion(rs.getString("religion"));
				admissions.setMarital_status(rs.getString("marital_status"));
				//Admissions.setEthnicity(rs.getString("ethnicity"));
				//Admissions.setDiagnosis(rs.getString("diagnosis"));
				admissions.setId(rs.getLong("id"));
				admissions.setSubject_id(rs.getLong("subject_id"));
				admissions.setHadm_id(rs.getLong("hadm_id"));
				//Admissions.setAdmittime(rs.getDate("admittime"));
				//Admissions.setDischtime(rs.getDate("dischtime"));
				//Admissions.setDeathtime(rs.getDate("deathtime"));
				//Admissions.setAdmission_type(rs.getString("admission_type"));
				//Admissions.setAdmission_location(rs
					//	.getString("admission_location"));
				//Admissions.setDischarge_location(rs
					//	.getString("discharge_location"));
				//Admissions.setInsurance(rs.getString("insurance"));
				//Admissions.setLanguage(rs.getString("language"));
				//Admissions.setReligion(rs.getString("religion"));
				admissions.setMarital_status(rs.getString("marital_status"));
				//Admissions.setEthnicity(rs.getString("ethnicity"));
				//Admissions.setDiagnosis(rs.getString("diagnosis"));
			}
			return admissions;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean editAdmissions(Admissions Admissions) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAdmissions(Admissions Admissions) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("delete  from admissions where id=? ");
			ps.setLong(1, Admissions.getId());
			return ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object[] getDataForLos(List<Long> hadmIds) {
		
		        String str ="";
				for(long k : hadmIds)
					 str = str + k + ","; 
				str = str.substring(0,str.length()-1);
		
			    List<Double[]> attributes =new ArrayList<Double[]>();
			    List<Double> losList =new ArrayList<Double>();
			    	Connection conn = null;
					try {
						conn = MyConnection.getConnectionObj();
			    	    PreparedStatement ps = conn
			   			  .prepareStatement("select a.los as los,p.age as age,a.admission_type as at,p.gender as gender from admissions as  a join patients as  p on "
			   			  		+ " (a.subject_id=p.subject_id) where a.hadm_id  in"
			   			  		+ " ("+str+") "); 
			   			  
			   			  
			    	    ResultSet rs =ps.executeQuery();
			    	    while(rs.next()){
				    	    double los = rs.getInt("los");
				    	    double age =  rs.getInt("age");
				    	    String admisssionType =  rs.getString("at");
				    	    double at = admisssionType.equals("EMERGENCY")?1:admisssionType.equals("NEWBORN")?2:admisssionType.equals("ELECTIVE")?3:4;
				    	    
				    	    double gender = rs.getString("gender").equals("M")?1:2;
				    	    attributes.add(new Double[] {age,at,gender});
				    	    losList.add(los);
			    	    }
                   
			    	   return new Object[]{attributes,losList};
			   			  
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
					
	}

}