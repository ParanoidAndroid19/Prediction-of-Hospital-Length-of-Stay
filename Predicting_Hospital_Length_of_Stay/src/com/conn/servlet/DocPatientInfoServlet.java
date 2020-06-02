package com.conn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.dao.AdmissionsDaoImpl;
import com.conn.dao.LoginInfoDaoImpl;
import com.conn.dao.LoginInfoInterface;
import com.conn.dao.PatientsDaoImpl;
import com.conn.dao.PatientsInterface;
import com.conn.pojo.Admissions;
import com.conn.pojo.LoginInfo;
import com.conn.pojo.Patients;

/**
 * Servlet implementation class DocPatientInfoServlet
 */
public class DocPatientInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocPatientInfoServlet() {
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
		
		String action =request.getParameter("action");
		
		if(action==null)
			response.sendRedirect("login.jsp");
		if(action.equals("getAllpatients")){
			PatientsInterface patientsInterface = new PatientsDaoImpl();
			List<Patients> patients = patientsInterface.patientsList();
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("patientList.jsp");
			request.setAttribute("patientList", patients);
			requestDispatcher.forward(request, response);
		}
		else if(action.equals("getAllDoctors")){
			LoginInfoInterface loginInfoInterface = new LoginInfoDaoImpl();
			List<LoginInfo> loginInfos = loginInfoInterface.getLoginInfoByRoleEqualsDoctorAndStatusEqualsActive();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("doctorList.jsp");
			request.setAttribute("doctorList", loginInfos);
			requestDispatcher.forward(request, response);
		}
		else if(action.equals("redirectToDiseasePage")){
			
			Long subjectId = Long.parseLong(request.getParameter("subjectId"));
			Admissions admissions = new AdmissionsDaoImpl().getElementBySubjectId(subjectId);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("addDisease.jsp");
			request.setAttribute("subjectId", admissions.getId());
			requestDispatcher.forward(request, response);
		}
	}

}
