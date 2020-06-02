<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
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
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>



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
	
	<div class="container bodySpace"> 
	<div class="row login-box" id="logBox">
		    <div class="col-sm-8"></div>
			<div class="col-sm-4" style="margin-top:50px;">
			<form  action="LoginServlet" method="post" class="registration-form">
					<label style="color:red;">${message}</label>			                    		
				
				    <h4 style="text-align: center;">WELCOME TO LOGIN</h4>
				     
				    <br>
				    <div class="form-group">
					    <select class="form-control" name="role" id="role">
					     <option value="doctor">Doctor</option>
					     <option value="admin">Admin</option>
					    </select>
					</div>
					<div class="form-group">
					    <input type="text" class="form-control" id="user_name" name="user_name" placeholder="username"  required>
					</div>
					<div class="form-group">
					    <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
					</div>
					
					
					<div class="text-center">
						<button type="submit" class="btn btn-success" name="action" value="login"   style="background-color: #01a185;">Login</button>
					</div>
					<br>
					<a onclick="toggle(0)" style="text-decoration:none;cursor: pointer;margin-top: 4px;"  >Register a new membership</a>
					<hr style="border-top: 1px solid #f3c500;">	
				
			</form>
			</div>
	</div>
	
	<!-- registration -->
	<div class="row login-box" id="regBox" style="display:none;">
		    <div class="col-sm-8"></div>
			<div class="col-sm-4" style="margin-top:15px;">
			<form  action="LoginServlet" method="post" class="registration-form">
					<label style="color:red;">${message}</label>			                    		
				
				    <h4 style="text-align: center;">Register a new membership</h4>
				     
				    <br>
				    <div class="form-group">
					    <select class="form-control" name="role" id="role">
					     <option value="doctor">Doctor</option>
					    </select>
					</div>
					<div class="form-group">
					    <input type="text" class="form-control" id="name" name="name" placeholder="Name"  required>
					</div>
					<div class="form-group">
					    <input type="email" class="form-control" id="user_name" name="user_name" placeholder="Email Id"  required>
					</div>
					<div class="form-group">
					    <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
					</div>
					<div class="form-group">
					    <input type="text" class="form-control" id="address" name="address" placeholder="Address"  required>
					</div>
					<div class="form-group">
					    <input type="text" class="form-control" id="city" name="city" placeholder="City"  required>
					</div>
					<div class="form-group">
					    <input type="text" class="form-control" id="state" name="state" placeholder="State"  required>
					</div>
					<div class="form-group">
					    <input type="number" class="form-control" id="pincode" name="pincode" placeholder="Pincode"  required>
					</div>
					<div class="form-group">
					    <input type="number" class="form-control" id="contact_no" name="contact_no" placeholder="Contact No"  required>
					</div>
					
					<div class="text-center">
						<button type="submit" class="btn btn-success" name="action" value="registration"   style="background-color: #01a185;">Register</button>
					</div>
					
					<br>
					<a onclick="toggle(1)" style="text-decoration:none;cursor: pointer;"  class="text-center">I already have a membership</a>
					<hr style="border-top: 1px solid #f3c500;">	
				
			</form>
			</div>
	</div>
	
	</div>
 <jsp:include page="footer.jsp"></jsp:include>
	 
<script type="text/javascript">

function toggle(v){
	 $(".login-box").css('display','none');
	if(v==0)
		$("#regBox").css('display','block');
	else if(v==1)
		$("#logBox").css('display','block');
	else if(v==2)
		$("#forgetPassBox").css('display','block');
	
}


</script>		
</body>
</html>