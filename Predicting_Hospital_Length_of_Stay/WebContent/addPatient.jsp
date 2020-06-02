<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Patient</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
 <link rel="Stylesheet" href="css/HCo_fonts.css" />
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/datepicker3.css" />
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>

<script>
	
			
	
</script>

			
<style type="text/css">




</style>

</head>
<body>
<c:set var="today" value="<%=new java.util.Date()%>" />
	<jsp:include page="menu.jsp"></jsp:include>
	
	 <div class="container" style="margin-top:100px;"> 
        <div class="bodyContainer">
        	<div class="panel panel-default mtop20">
				<div class="panel-heading">
          			<h3 class="panel-title">Add Patient</h3>
        		</div>
        	 <div class="panel-body" style="padding-bottom: 75px;">
         		<div class="panel-body">
         <form  action="AdmissionsServlet" method="post" class="registration-form">
         
         
         	  <div id="basicInfo" class="patientsDiv">
		         <div class="row">
			          <div class="col-sm-3"></div>
			           <div class="col-sm-6">
			            <div class="form-group has-feedback">
							 <label>Patient Name</label>            
							 <input type="text" name="patient_name" class="form-control input-sm"  value="don" required>
						</div>
			            </div>
		           </div>
		           
		           
		           <div class="row">
			          <div class="col-sm-3"></div>
			            <div class="col-sm-3">
			            <div class="form-group has-feedback">
							 <label>Age</label>            
							 <input type="number" name="age" value="58"  class="form-control input-sm" required>
						</div>
			           </div>
			           <div class="col-sm-3">
			            <div class="form-group has-feedback">
							 <label>Gender</label>            
							 <select class="form-control input-sm" name="gender">
							  <option value="M">Male</option>
							  <option value="F">Female</option>
							 </select>
						</div>
			           </div>
		           </div>
		           
		           
		           
		           <div class="row">
			          <div class="col-sm-3"></div>
			           <div class="col-sm-3">
			            <div class="form-group has-feedback">
							 <label>Date of Birth</label>            
							 <input class="form-control datepicker input-sm"  value="12-02-1976" name="dob" id="dob" />
						</div>
			            </div>
			            
			            <div class="col-sm-3">
			            <div class="form-group has-feedback">
							 <label>Admit-Time</label>            
							 <input class="form-control datepicker input-sm" value="<fmt:formatDate pattern = "dd-MM-yyyy" value = "${today}" />" name="admittime" id="admittime" />
						</div>
			            </div> 
		           </div>
		            <div class="row" style="margin-bottom: 10px;">
				        <!-- /.col -->
				        <div class="col-sm-5"></div>
				        <div class="col-sm-3">
				          <button type="button"  class="btn btn-default" onclick="navigate('2')">Next</button>
				        </div>
				   </div>
             </div>
             <!--  
			              
			             
			              diagnosis -->
             <div id="admissionInfo" class="patientsDiv" style="display:none;">
                
                 <div class="row">
			          <div class="col-sm-3"></div>
			           <div class="col-sm-8">
			            <div class="row">
			              <div class="col-sm-5">
			                <div class="form-group has-feedback">
							 <label>Admission Type</label>   
							 <select class="form-control input-sm" name="admission_type" id="admission_type">
							  <option value="EMERGENCY">EMERGENCY</option>
							  <option value="NEWBORN">NEWBORN</option>
							  <option value="ELECTIVE">ELECTIVE</option>
							  <option value="URGENT">URGENT</option>
							 </select>         
							 </div>
			              </div>
			              <!-- <div class="col-sm-5">
				              <div class="form-group has-feedback">
								 <label>Location</label>            
								 <select class="form-control input-sm" name="admission_location" id="admission_location">
									  <option value="EMERGENCY">EMERGENCY</option>
									  <option value="CLINIC REFERRAL">CLINIC REFERRAL</option>
									  <option value="PHYS REFERRAL">PHYS REFERRAL</option>
								 </select> 
							    </div>
			              </div> -->
			            </div>
			            
			            <div class="row">
			              <div class="col-sm-5">
			                <div class="form-group has-feedback">
							 <label>Religion</label>   
							   
							 <select class="form-control input-sm" name="religion" id="religion">
									  <option value="CATHOLIC">CATHOLIC</option>
									  <option value="JEWISH">JEWISH</option>
									  <option value="NOT SPECIFIED">NOT SPECIFIED</option>
								 </select>      
							 </div>
			              </div>
			              <div class="col-sm-5">
				              <div class="form-group has-feedback">
								 <label>Marital Status</label>            
								 <select class="form-control input-sm" name="marital_status" id="marital_status">
									  <option value="MARRIED">MARRIED</option>
									  <option value="SINGLE">SINGLE</option>
									  <option value="NONE">NONE</option>
								 </select>
							    </div>
			              </div>
			            </div>
			            
			            
			             <!-- <div class="row">
			              <div class="col-sm-5">
			                <div class="form-group has-feedback">
							 <label>Diagnosis</label>   
							  <select class="form-control input-sm" name="diagnosis" id="diagnosis">
							  		  <option value="-1">Select Diagnosis</option>
									  <option value="CHEST PAIN">CHEST PAIN</option>
									  <option value="CORONARY ARTERY DISEASE">CORONARY ARTERY DISEASE</option>
									  <option value="FEVER">FEVER</option>
							</select>      
							 </div>
			              </div>
			              <div class="col-sm-5" >
				              <div class="form-group has-feedback">
								 <label>Symptoms</label>         <br>
								 <input type="checkbox" name="symptoms"  value="431">Intracerebral hemorrhage <br>
								 <input type="checkbox" name="symptoms"  value="2449">Hypothyroidism NOS <br>
								 <input type="checkbox" name="symptoms"  value="4019">Hypertension NOS <br>
								 <input type="checkbox" name="symptoms"  value="2948">Mental disor NEC oth dis <br>
								 <input type="checkbox" name="symptoms"  value="311">Cutaneous mycobacteria <br>
								 <input type="checkbox" name="symptoms"  value="40301">Mal hyp kid w cr kid V <br>
								 <input type="checkbox" name="symptoms"  value="7100">Syst lupus erythematosus<br>
								 <input type="checkbox" name="symptoms"  value="2762">Acidosis<br>
								 <input type="checkbox" name="symptoms"  value="2875">Thrombocytopenia NOS<br>
								 <input type="checkbox" name="symptoms"  value="5589">Noninf gastroenterit NEC <br>
							    </div>
			              </div>
			              
			            </div> -->
			            
			            
			            
			           </div>
		           </div>
		           
                 <div class="row" style="margin-bottom: 10px;">
				        <!-- /.col -->
				        <div class="col-sm-5"></div>
				        <div class="col-sm-6">
				        	<button type="button"  class="btn btn-default" onclick="navigate('1')">Back</button>
				        	<button type="submit"  class="btn btn-success " name="action" value="Save">Submit</button>
				        </div> 
				        
				   </div>
             
             </div>
              
         
               
           
           </form>
            
         </div>            
         	</div>
          </div>
        </div>
       </div>
	
 <jsp:include page="footer.jsp"></jsp:include>
	 
<script type="text/javascript">

function navigate(id){
	
	$(".patientsDiv").css('display','none');
	if(id=='1')
		$("#basicInfo").css('display','block');
	else
		$("#admissionInfo").css('display','block');
	
	
}

/* $(document).ready(function(){
	$('.datepicker').datepicker({
		format: 'dd-mm-yyyy',
	    autoclose: true
	    
	});
})
 */
</script>		
</body>
</html>