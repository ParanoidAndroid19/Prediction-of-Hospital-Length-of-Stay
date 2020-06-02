package com.conn.dao;

import java.util.List;

import com.conn.pojo.SymptomsIcd;

public interface SymptomsIcdDao {
	public List<Long>  fetchHadmIdsMatchWithGivenSymptoms(String symptoms[]); 

}
