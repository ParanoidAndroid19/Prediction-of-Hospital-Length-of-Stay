
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
	
	<div class="navbar" style="background-color:white;"> 
                    <div class="container">
                          <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                              <li class="projectName">
                              <div class="logo">
								<a onclick="return false;"><span>Predicting </span>Hospital Length of Stay</a>
							</div>
                              </li>
                              </ul>
                              
                              <c:if test="${user.role=='admin'}">
	                              <ul class="nav navbar-nav pull-right">
		                               <li><a href="adminHome.jsp">Home</a>
	                                   </li>
	                                   <li><a href="addPatient.jsp">Add patient</a></li>
	                                   <!-- <li><a href="DocPatientInfoServlet?action=getAllDoctors">Doctors</a>
	                                   </li> -->
	                                   <li><a href="DocPatientInfoServlet?action=getAllpatients">Patients</a>
	                                   </li>
	                                   <!-- <li class="dropdown">
									        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Resource Management
									        <span class="caret"></span></a>
									        <ul class="dropdown-menu">
									          <li><a  href="#">Add Caregivers</a></li>
									          <li><a  href="#">Caregivers List</a></li>
									          <li><a  href="#">Add Rooms & Beds</a></li>
									          <li><a  href="#">Rooms</a></li>
									        </ul>
								        </li> -->
	                                    <li class="dropdown">
									        <a class="dropdown-toggle" data-toggle="dropdown" href="#">${user.name}
									        <span class="caret"></span></a>
									        <ul class="dropdown-menu">
									          <li><a  href="LogoutServletMaster">Logout</a></li>
									        </ul>
								        </li>
	                               </ul>
                               </c:if>
                               
                               
                               <c:if test="${user.role=='doctor'}">
	                              <ul class="nav navbar-nav pull-right">
		                              <li><a href="doctorHome.jsp">Home</a>
	                                  </li>
	                                  <!-- <li><a href="addPatient.jsp">Add patient</a>
	                                  </li> -->
	                                   <li><a href="DocPatientInfoServlet?action=getAllpatients">Patients</a>
	                                   </li>
	                                    <li class="dropdown">
									        <a class="dropdown-toggle" data-toggle="dropdown" href="#">${user.name}
									        <span class="caret"></span></a>
									        <ul class="dropdown-menu">
									          <li><a  href="LogoutServletMaster">Logout</a></li>
									        </ul>
								        </li>
	                               </ul>
                               </c:if>
                               
                               
                            </div>
                      </div>
</div>
	