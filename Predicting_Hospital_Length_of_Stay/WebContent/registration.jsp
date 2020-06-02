<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-select.css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Resale Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!--//fonts-->	
<!-- js -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- js -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.js"></script>

 <script type="text/javascript">
$(document).ready(function(){


	 var showId=$("#showId").val();
            var action="country";
        	$.get('CountryServlet',{action:action},function(a){

            
            $(document).find("#countrySelect").empty();
              $(document).find("#countrySelect").append(a);

            });
        

    
    $("#countrySelect").change(function(){
			
            var action="state";
           var id=$("#countrySelect").val();
        $.get('CountryServlet',{action:action,id:id},function(a){

           
            $(document).find("#stateSelect").empty();
              $(document).find("#stateSelect").append(a);

            });




        });
    $("#stateSelect").change(function(){

            var action="city";
            var id=$("#stateSelect").val();
           
        $.get('CountryServlet',{action:action,id:id},function(a){

           
            $(document).find("#citySelect").empty();
              $(document).find("#citySelect").append(a);

            
            });


       
        });
 });
</script>

<script>
  $(document).ready(function () {
    var mySelect = $('#first-disabled2');

    $('#special').on('click', function () {
      mySelect.find('option:selected').prop('disabled', true);
      mySelect.selectpicker('refresh');
    });

    $('#special2').on('click', function () {
      mySelect.find('option:disabled').prop('disabled', false);
      mySelect.selectpicker('refresh');
    });

    $('#basic2').selectpicker({
      liveSearch: true,
      maxOptions: 1
    });
  });
</script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<link href="css/jquery.uls.css" rel="stylesheet"/>
<link href="css/jquery.uls.grid.css" rel="stylesheet"/>
<link href="css/jquery.uls.lcd.css" rel="stylesheet"/>
<!-- Source -->
<script src="js/jquery.uls.data.js"></script>
<script src="js/jquery.uls.data.utils.js"></script>
<script src="js/jquery.uls.lcd.js"></script>
<script src="js/jquery.uls.languagefilter.js"></script>
<script src="js/jquery.uls.regionfilter.js"></script>
<script src="js/jquery.uls.core.js"></script>

<script>
	
			$(document).ready(function() {
				var path="";
				
			    function disableBack() { window.history.forward() }
			
			    window.onload = disableBack();
			    window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
			});
	
	</script>
<script>
			$( document ).ready( function() {
				$( '.uls-trigger' ).uls( {
					onSelect : function( language ) {
						var languageName = $.uls.data.getAutonym( language );
						$( '.uls-trigger' ).text( languageName );
					},
					quickList: ['en', 'hi', 'he', 'ml', 'ta', 'fr'] //FIXME
				} );
			} );
		</script>
		
		
		<style type="text/css">
			.logo a {
				  font-size: 26px;
				  }
		  .header {
  				padding: 10px 0;
  				}
  		 .footer-logo
  		         {
				  font-size: 26px;
				  }
		</style>
		
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="logo">
				<a href=""><span>Cloud Data Security </span>Using Color Cryptosystem</a>
			</div>
			 
		</div>
	</div>
	
	<hr style="border-top: 1px solid #f3c500;">
	 <br>
	<div class="row">
		<div class="col-sm-12">
			<div class="col-sm-4"></div>
			
			<div class="col-sm-4">
			
		  <form role="form" action="RegistrationServlet" method="post" class="registration-form">
				    <h3 style="text-align: center;">WELCOME, REGISTER HERE..</h3>
				    <br>
					<div class="form-group">
						<label for="smallinput" class="control-label label-input-sm">First Name</label>
					    <input type="text" class="form-control1 input-sm" id="smallinput" name="fname" placeholder="First Name.." required >
					</div>
					<div class="form-group">
						<label for="smallinput" class="control-label label-input-sm">Email</label> 
					    <input type="email" class="form-control1 input-sm" id="smallinput"  name="email" placeholder="Email"  required>
					</div>
					<div class="form-group">
						<label for="smallinput" class="control-label label-input-sm">Password</label>
					    <input type="password" class="form-control1 input-sm" id="smallinput" name="PASSWORD"   placeholder="Password.."  required>
					</div>
					<div class="form-group">
						<label for="smallinput" class="control-label label-input-sm">Address</label>
					    <textarea class="form-control1 input-sm" id="smallinput" name="ADDRESS"    placeholder="Address.." rows="3"  required></textarea>
					</div>
					<div class="form-group">
						<label for="smallinput" class="control-label label-input-sm" >Country</label>
					    <select class="form-control" name="country"  id="countrySelect" style="border-radius:0px;"  required>
					    	 
					    </select>
					</div>
					<div class="form-group">
						<label for="smallinput" class="control-label label-input-sm">State</label>
					    <select class="form-control" name="state"  id="stateSelect" style="border-radius:0px;"  required>
					    	 
					    </select>
					</div>
					<div class="form-group">
						<label for="smallinput" class="control-label label-input-sm">City</label>
					    <select class="form-control"  id="citySelect"  name="city" style="border-radius:0px;"  required>
					    	 
					    </select>
					</div>
					<div class="form-group">
						<label for="smallinput" class="control-label label-input-sm">Pincode</label>
					     <input type="number" class="form-control1 input-sm" id="smallinput" name="PINCODE"    placeholder="Pincode" maxlength="6"  required>
					</div>
					
				
				<br>
				<div class="text-center">
					<button type="submit" class="btn btn-success" name="action" value="signUp"  style="background-color: #01a185;">Save</button>
					<a href="Login.jsp"><button type="button" class="btn btn-success" style="background-color: #f3c500;">Login</button></a>
					
				</div>
				</form>
				
			</div>
			
		</div>
	</div>

<br><br><br>
<br> 
	 
		<!--footer section start-->		
		<footer>
			 
			<div class="footer-bottom text-center">
			<div class="container">
				 
				 
				<div class="copyrights">
					<marquee><p> © 2016 <a href=""><span>Cloud Data Security </span>Using Color Cryptosystem</a> All Rights Reserved </p></marquee>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		</footer>
        <!--footer section end-->
</body>
</html>