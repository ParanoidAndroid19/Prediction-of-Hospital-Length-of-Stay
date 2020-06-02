package com.conn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.conn.pojo.SymptomsIcd;
import com.login.utility.MyConnection;

public class SymptomsIcdDaoImpl implements SymptomsIcdDao{

	@Override
	public List<Long> fetchHadmIdsMatchWithGivenSymptoms(String symptoms[]) {
		
		List<String> symptomsList = Arrays.asList(symptoms);
		try {
			Connection conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from symptoms_icd");
			ResultSet rs = ps.executeQuery();
			List<Long>  hadmIds = new ArrayList<Long>();
			while (rs.next()) {
				List<String> currentList =  Arrays.asList(rs.getString("symptoms").split(","));
				if(currentList.containsAll(symptomsList))
					hadmIds.add(rs.getLong("hadm_id"));
			}
			return hadmIds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
