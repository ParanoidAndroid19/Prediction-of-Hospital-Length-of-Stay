<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Doctor Home</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
 <link rel="Stylesheet" href="css/HCo_fonts.css" />
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>



<script>
	
			$(document).ready(function() {
				var path="";
				
			    function disableBack() { window.history.forward() }
			
			    window.onload = disableBack();
			    window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
			});
	
</script>

			
		
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	
	 <div class="container" > 
        <div class="bodyContainer">
        	<div class="panel panel-default mtop20">
				<div class="panel-heading">
          			<h3 class="panel-title">Project Description</h3>
          			 Predicting hospital length of stay is of substantial value for hospital resource planning and management. Being able to better estimate how much longer a patient will remain in hospital, can assist in scheduling the usage of wards and hospital beds including the scheduling of elective surgeries based on upcoming availability of beds. This will ultimately assist hospitals and patients by reducing the expenditure. This project focuses on prediction for patient diagnosed with various diseases in hospital.The project will make use of multiple regression algorithm for predicting the total length of stay for patients with various diagnoses based on selected general characteristics. A regression model is trained to predict the total number of days the patient will stay in the hospital from the time of admission. The model will also help in prediction of the resource requirements of each patients such as the number of rooms, beds, hospital staff and making clinical support decisions.

          			 
        		</div>
        	 <div class="panel-body">
         		<div class="row" style="margin-top: 100px;margin-bottom: 100px;">
           			<div class="col-sm-12">
           			</div>
           		</div>
            
         	</div>
          </div>
        </div>
       </div>
	
 <jsp:include page="footer.jsp"></jsp:include>
	 
		
</body>
</html>