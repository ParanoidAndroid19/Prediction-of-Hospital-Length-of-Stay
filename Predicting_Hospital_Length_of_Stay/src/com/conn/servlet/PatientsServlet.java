package com.conn.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.dao.PatientsDaoImpl;
import com.conn.dao.PatientsInterface;
import com.conn.pojo.Patients;
import com.login.utility.DateUtil;


/**
 * Servlet implementation class PatientsServlet
 */
public class PatientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		
	    PatientsInterface PatientsInterface=new PatientsDaoImpl();
		
		 
		if(action!=null && action.equals("save"))
		{	 
			Patients patient=new Patients();	  
           
		   String patient_name = request.getParameter("patient_name");
		   int age = Integer.parseInt(request.getParameter("age"));
           String gender = request.getParameter("gender");
           Date dob = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dob"));
           Date dod = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dod"));
           Date dod_hosp = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dod_hosp"));
           Date dod_ssn = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dod_ssn"));
           
			   
            
           patient.setPatient_name(patient_name);
           patient.setAge(age);
           patient.setGender(gender); 
           patient.setDob(dob); 
           patient.setDod(dod); 
           patient.setDod_hosp(dod_hosp); 
           patient.setDod_ssn(dod_ssn); 
           patient.setExpire_flag("false");
		
		   PatientsInterface.save(patient);
		   PatientsInterface patientsInterface = new PatientsDaoImpl();
		   List<Patients> patientList = patientsInterface.patientsList();
			
		   RequestDispatcher requestDispatcher = request.getRequestDispatcher("patientList.jsp");
		   request.setAttribute("patientList", patientList);
		   requestDispatcher.forward(request, response);
		 
			
		}
		
		else if(action!=null && action.equals("GetAllListById"))
		{
		   Patients patient=new Patients();
           long id = Long.parseLong(request.getParameter("id"));
           long subject_id = Long.parseLong(request.getParameter("subject_id"));
           String gender = request.getParameter("gender");
           Date dob = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dob"));
           Date dod = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dod"));
           Date dod_hosp = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dod_hosp"));
           Date dod_ssn = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dod_ssn"));
           String expire_flag = request.getParameter("expire_flag");
			 
           patient.setId(id); 
           patient.setSubject_id(subject_id); 
           patient.setGender(gender); 
           patient.setDob(dob); 
           patient.setDod(dod); 
           patient.setDod_hosp(dod_hosp); 
           patient.setDod_ssn(dod_ssn); 
           patient.setExpire_flag(expire_flag);
			
           //Patients=PatientsInterface.getElementById(Patients);
			
			//session.removeAttribute("Patients");
			//session.setAttribute("Patients", Patients);
		   //response.sendRedirect("#");
		}
		
		
		
		else if(action!=null && action.equals("Update"))
		{
			
		   Patients patient=new Patients();
           long id = Long.parseLong(request.getParameter("id"));
           long subject_id = Long.parseLong(request.getParameter("subject_id"));
           String gender = request.getParameter("gender");
           Date dob = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dob"));
           Date dod = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dod"));
           Date dod_hosp = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dod_hosp"));
           Date dod_ssn = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dod_ssn"));
           String expire_flag = request.getParameter("expire_flag");
			 
           patient.setId(id); 
           patient.setSubject_id(subject_id); 
           patient.setGender(gender); 
           patient.setDob(dob); 
           patient.setDod(dod); 
           patient.setDod_hosp(dod_hosp); 
           patient.setDod_ssn(dod_ssn); 
           patient.setExpire_flag(expire_flag);
		}
		
		else
		{
			 response.sendRedirect("#");
		}
		 
		
	}

}
