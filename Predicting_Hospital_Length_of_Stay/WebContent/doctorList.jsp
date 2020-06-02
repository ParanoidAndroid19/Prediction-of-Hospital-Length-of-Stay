<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Doctors</title>
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
     <link rel="Stylesheet" href="css/dataTables.bootstrap.css" />    
     <script type="text/javascript" src="js/bootstrap.js"></script> 
     <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
     <script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>



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
          			<h3 class="panel-title">Doctors</h3>
        		</div>
        	 <div class="panel-body">
         		<div class="row" style="margin-top: 25px;margin-bottom:10px;">
           			<div class="col-sm-12">
           			<table id="docList" class="table table-bordered table-striped hover">
              <thead>
                <tr>
                  <th>No</th>
                  <th>Name</th>
                  <th>Email Id</th>
                  <th>Contact No</th>
                  <th>City</th>
                  <th>State</th>
                </tr>
              </thead>
              <tbody>
              <c:set var="i" value="1"></c:set>
              <c:forEach var="doctor" items="${doctorList}"> 
               <tr>
                 <td>${i}</td>
                 <td>${doctor.name}</td>
                 <td>${doctor.user_name}</td>
                 <td>${doctor.contact_no}</td>
                 <td>${doctor.city}</td>
                 <td>${doctor.state}</td>
               </tr>
               <c:set var="i" value="${i+1}"></c:set>
               </c:forEach>
              </tbody>
             </table>
           			</div>
           		</div>
            
         	</div>
          </div>
        </div>
       </div>
	
 <jsp:include page="footer.jsp"></jsp:include>
	 <script type="text/javascript">


$(function () {
 
  $('#docList').DataTable({
    "paging": true,
    "lengthChange": true,
    "searching": true,
    "ordering": true,
    "info": true,
    "autoWidth": true,
    "lengthMenu": [5]
  }); 
});

</script>
		
</body>
</html>