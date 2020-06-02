package com.conn.pojo;

import java.sql.Date;

public class Patients {

private long id;
private String patient_name;
private int age;
private long subject_id;
private String gender;
private Date dob;
private Date dod;
private Date dod_hosp;
private Date dod_ssn;
private String expire_flag;
private long current_t;


   
 public long  getId()   {   
  return   id; 
    }  
 public  void  setId (long  id)   {  
  this.id=id; 
  }  
 
 public long  getSubject_id()   {   
  return   subject_id; 
    }  
 public  void  setSubject_id (long  subject_id)   {  
  this.subject_id=subject_id; 
  }  
 
 public String  getGender()   {   
  return   gender; 
    }  
 public  void  setGender (String  gender)   {  
  this.gender=gender; 
  }  
 
 public Date  getDob()   {   
  return   dob; 
    }  
 public  void  setDob (Date  dob)   {  
  this.dob=dob; 
  }  
 
 public Date  getDod()   {   
  return   dod; 
    }  
 public  void  setDod (Date  dod)   {  
  this.dod=dod; 
  }  
 
 public Date  getDod_hosp()   {   
  return   dod_hosp; 
    }  
 public  void  setDod_hosp (Date  dod_hosp)   {  
  this.dod_hosp=dod_hosp; 
  }  
 
 public Date  getDod_ssn()   {   
  return   dod_ssn; 
    }  
 public  void  setDod_ssn (Date  dod_ssn)   {  
  this.dod_ssn=dod_ssn; 
  }  
 
 public String  getExpire_flag()   {   
  return   expire_flag; 
    }  
 public  void  setExpire_flag (String  expire_flag)   {  
  this.expire_flag=expire_flag; 
  }
public String getPatient_name() {
	return patient_name;
}
public void setPatient_name(String patient_name) {
	this.patient_name = patient_name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getCurrent_t() {
	return current_t;
}
public void setCurrent_t(long current_t) {
	this.current_t = current_t;
}

	
	
}