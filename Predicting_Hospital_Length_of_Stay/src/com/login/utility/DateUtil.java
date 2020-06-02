package com.login.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
  
	public static java.sql.Date converdd_mm_yyyToSqlDate(String stringDate){
		 java.sql.Date  sqlDate=null;
		try {
			Date utilDate =new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}
}
