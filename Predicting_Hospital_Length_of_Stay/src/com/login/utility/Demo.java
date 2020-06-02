package com.login.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from patients ");
			ResultSet rs = ps.executeQuery();
	
			String s ="";
			
			Long hadm_id = null;
			Map<Long,String> map = new HashMap<Long,String>();
			while (rs.next()) {
				
				try {
					String dobArr[] =rs.getString("dob").split("-");
					String yr[] = dobArr[2].split(" ");
					Integer year = Integer.parseInt(yr[0]);
					String date=null;
					if(dobArr[0].length()>2)
					   date =  rs.getString("dob").split(" ")[0];
					else{
						if(year > 2100)
							year = year - 200;
						else
							year = year - 100;
						
						 date =  year + "-" +dobArr[1] + "-" + dobArr[0];	
					   }
					
					
					update(conn,date,rs.getLong("id"));
				} catch (Exception e) {
					System.out.println(rs.getLong("id"));
				}
				
//				if(date)
//				if(hadm_id==null){
//					hadm_id=rs.getLong("hadm_id");
//				}
//				if(hadm_id==rs.getLong("hadm_id")){
//					s = s  + rs.getLong("icd9_code") + ",";
//				}else{
//					map.put(hadm_id, s);
//					insert(conn, hadm_id, s);
//					s = ""+rs.getLong("icd9_code");
//					hadm_id = rs.getLong("hadm_id");
//				}
			}
			
			
			
			//insert(conn, hadm_id, s);
			 
			//System.out.println("done " + map.values());
			//return DiagnosesList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return null;
	}
  private static void update(Connection conn, String date, long id) {
	  PreparedStatement ps1=null;
		try {
			ps1 = conn
					.prepareStatement("update patients set dob=? where id = ?");
			ps1.setString(1, date);
			ps1.setLong(2, id);
			ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static void insert(Connection conn,Long hadm_id,String s){
	     PreparedStatement ps1=null;
		try {
			ps1 = conn
					.prepareStatement("insert into symptoms_icd(hadm_id,symptoms) values (?,?)");
			ps1.setLong(1, hadm_id);
			ps1.setString(2, s);
			ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
  }
}
