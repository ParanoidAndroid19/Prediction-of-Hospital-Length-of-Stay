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

import org.omg.CORBA.RepositoryIdHelper;

import com.conn.dao.AdmissionsDaoImpl;
import com.conn.dao.AdmissionsInterface;
import com.conn.dao.PatientsDaoImpl;
import com.conn.dao.PatientsInterface;
import com.conn.dao.SymptomsIcdDao;
import com.conn.dao.SymptomsIcdDaoImpl;
import com.conn.pojo.Admissions;
import com.conn.pojo.Patients;
import com.login.utility.DateUtil;
import com.login.utility.MultipleLinearRegression;


/**
 * Servlet implementation class AdmissionsServlet
 */
public class AdmissionsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionsServlet() {
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


public Patients savePatient(HttpServletRequest request){

Patients patient=new Patients();  
PatientsInterface PatientsInterface=new PatientsDaoImpl();
String patient_name = request.getParameter("patient_name");
   int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        Date dob = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dob"));
       
        patient.setPatient_name(patient_name);
        patient.setAge(age);
        patient.setGender(gender);
        patient.setDob(dob);
        patient.setExpire_flag("false");

long patientId =  PatientsInterface.save(patient);
patient.setId(patientId);
patient.setSubject_id(patientId);
return patient;


}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub


HttpSession session=request.getSession();
String action=request.getParameter("action");

   AdmissionsInterface admissionsInterface=new AdmissionsDaoImpl();


if(action!=null && action.equals("Save"))
{


  Patients patients = savePatient(request);

  Admissions admissions=new Admissions();
  Date admittime = request.getParameter("admittime")!=null? DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("admittime")):null;
           Date dischtime = request.getParameter("dischtime")!=null? DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dischtime")):null;
           Date deathtime = request.getParameter("deathtime")!=null? DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("deathtime")):null;
           String admission_type = request.getParameter("admission_type");
           String admission_location = request.getParameter("admission_location");
           String discharge_location = request.getParameter("discharge_location");
           String insurance = request.getParameter("insurance");
           String language = request.getParameter("language");
           String religion = request.getParameter("religion");
           String marital_status = request.getParameter("marital_status");
           String ethnicity = request.getParameter("ethnicity");
           String diagnosis = request.getParameter("diagnosis");
           String symptoms[] = request.getParameterValues("symptoms");
           
           
 
           System.out.println("patient  id " +patients.getSubject_id());
           admissions.setSubject_id(patients.getSubject_id());
           admissions.setAdmittime(admittime);
           admissions.setDischtime(dischtime);
           admissions.setDeathtime(deathtime);
           admissions.setAdmission_type(admission_type);
           admissions.setAdmission_location(admission_location);
           admissions.setDischarge_location(discharge_location);
           admissions.setInsurance(insurance);
           admissions.setLanguage(language);
           admissions.setReligion(religion);
           admissions.setMarital_status(marital_status);
           admissions.setEthnicity(ethnicity);
           admissions.setDiagnosis(diagnosis);

           admissionsInterface.save(admissions);
 
  //int los= calculateLos(admissions, symptoms,patients);
 
  RequestDispatcher rD = request.getRequestDispatcher("DocPatientInfoServlet?action=getAllpatients");
  rD.forward(request, response);

}
else if(action!=null && action.equals("calculateLos")){

Long admissionId = Long.parseLong(request.getParameter("admissionId"));
Admissions admission = admissionsInterface.getElementById(admissionId);
Patients patient = new PatientsDaoImpl().getElementById(admission.getSubject_id());  
String symptoms[] = request.getParameterValues("symptoms[]");
List<Long> hadmIds =  new SymptomsIcdDaoImpl().fetchHadmIdsMatchWithGivenSymptoms(symptoms);
String los= calculateLos(admission, symptoms,patient);
response.getWriter().print(los);
}
else if(action!=null && action.equals("GetAllList"))
{
List AdmissionsList=new ArrayList();
AdmissionsList=admissionsInterface.AdmissionsList();
if(false)
{
AdmissionsList=null;
}
session.removeAttribute("AdmissionsList");
session.setAttribute("AdmissionsList", AdmissionsList);
   response.sendRedirect("#");
}


else if(action!=null && action.equals("GetAllListById"))
{

           long id = Long.parseLong(request.getParameter("id"));
           long subject_id = Long.parseLong(request.getParameter("subject_id"));
           long hadm_id = Long.parseLong(request.getParameter("hadm_id"));
           Date admittime = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("admittime"));
           Date dischtime = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("dischtime"));
           Date deathtime = DateUtil.converdd_mm_yyyToSqlDate(request.getParameter("deathtime"));
           String admission_type = request.getParameter("admission_type");
           String admission_location = request.getParameter("admission_location");
           String discharge_location = request.getParameter("discharge_location");
           String insurance = request.getParameter("insurance");
           String language = request.getParameter("language");
           String religion = request.getParameter("religion");
           String marital_status = request.getParameter("marital_status");
           String ethnicity = request.getParameter("ethnicity");
           String diagnosis = request.getParameter("diagnosis");
           Admissions admissions=new Admissions();
           admissions.setId(id);
           admissions.setSubject_id(subject_id);
           admissions.setHadm_id(hadm_id);
           admissions.setAdmittime(admittime);
           admissions.setDischtime(dischtime);
           admissions.setDeathtime(deathtime);
           admissions.setAdmission_type(admission_type);
           admissions.setAdmission_location(admission_location);
           admissions.setDischarge_location(discharge_location);
           admissions.setInsurance(insurance);
           admissions.setLanguage(language);
           admissions.setReligion(religion);
           admissions.setMarital_status(marital_status);
           admissions.setEthnicity(ethnicity);
           admissions.setDiagnosis(diagnosis);

List AdmissionsListById=new ArrayList();
 
session.removeAttribute("AdmissionsListById");
session.setAttribute("AdmissionsListById", AdmissionsListById);
   response.sendRedirect("#");
}


}
 
private String calculateLos(Admissions admissions, String[] symptoms,Patients patients) {

SymptomsIcdDao symptomsIcdDao = new SymptomsIcdDaoImpl();
AdmissionsInterface admissionsInterface=new AdmissionsDaoImpl();
List<Long> hadmIds =  symptomsIcdDao.fetchHadmIdsMatchWithGivenSymptoms(symptoms);
try {
Object data[] = admissionsInterface.getDataForLos(hadmIds);
int los = MultipleLinearRegression.calculateLos(admissions,patients,(List<Double[]>)data[0], (List<Double>)data[1]);
return (""+los);
} catch (Exception e) {
 return "Record does not exist";
}


}

}