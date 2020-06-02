package com.conn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.dao.DiagnosesDaoImpl;
import com.conn.dao.DiagnosesInterface;
import com.conn.pojo.Diagnoses;


/**
 * Servlet implementation class DiagnosesServlet
 */
public class DiagnosesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosesServlet() {
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
		Diagnoses Diagnoses=new Diagnoses();
	    DiagnosesInterface DiagnosesInterface=new DiagnosesDaoImpl();
		
		 
		if(action!=null && action.equals("Save"))
		{	 
			  
           long id = Long.parseLong(request.getParameter("id"));
           String icd9_code = request.getParameter("icd9_code");
           String short_title = request.getParameter("short_title");
           String long_title = request.getParameter("long_title");
			   
           Diagnoses.setId(id); 
           Diagnoses.setIcd9_code(icd9_code); 
           Diagnoses.setShort_title(short_title); 
           Diagnoses.setLong_title(long_title);
		
		 DiagnosesInterface.save(Diagnoses);
		 response.sendRedirect("#");
			
		}
		
		
		else if(action!=null && action.equals("GetAllList"))
		{
			List DiagnosesList=new ArrayList();
			DiagnosesList=DiagnosesInterface.DiagnosesList();
			if(false)
			{
				DiagnosesList=null;
			}
			session.removeAttribute("DiagnosesList");
			session.setAttribute("DiagnosesList", DiagnosesList);
		    response.sendRedirect("#");
		}
		
		
		else if(action!=null && action.equals("GetAllListById"))
		{
			
           long id = Long.parseLong(request.getParameter("id"));
           String icd9_code = request.getParameter("icd9_code");
           String short_title = request.getParameter("short_title");
           String long_title = request.getParameter("long_title");
			 
           Diagnoses.setId(id); 
           Diagnoses.setIcd9_code(icd9_code); 
           Diagnoses.setShort_title(short_title); 
           Diagnoses.setLong_title(long_title);
			
			List DiagnosesListById=new ArrayList();
			DiagnosesInterface.getElementById(Diagnoses);
			
			session.removeAttribute("DiagnosesListById");
			session.setAttribute("DiagnosesListById", DiagnosesListById);
		   response.sendRedirect("#");
		}
		
		
		
		else if(action!=null && action.equals("Update"))
		{
			
			
           long id = Long.parseLong(request.getParameter("id"));
           String icd9_code = request.getParameter("icd9_code");
           String short_title = request.getParameter("short_title");
           String long_title = request.getParameter("long_title");
			 
           Diagnoses.setId(id); 
           Diagnoses.setIcd9_code(icd9_code); 
           Diagnoses.setShort_title(short_title); 
           Diagnoses.setLong_title(long_title);
		
		 DiagnosesInterface.save(Diagnoses);
		 response.sendRedirect("#");
		}
		
		else
		{
			 response.sendRedirect("#");
		}
		 
		
	}

}
