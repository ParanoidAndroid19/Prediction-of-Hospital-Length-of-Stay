<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Home</title>
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