<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>

<!-- (Optional) Latest compiled and minified JavaScript translation files -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/i18n/defaults-*.min.js"></script>

			
		
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	
	 <div class="container" > 
        <div class="bodyContainer">
        	<div class="panel panel-default mtop20">
				<div class="panel-heading">
          			<h3 class="panel-title">
          			
          			</h3>
        		</div>
        	 <div class="panel-body" style="margin-top: 20px;margin-bottom: 50px;">
         		<div class="row" style="margin-top: 20px;margin-bottom: 50px;">
         		   <div class="col-sm-3"></div>
           			<div class="col-sm-6">
           			   <select class="selectpicker" id="symptoms" data-live-search="true" multiple="multiple">
								 <option value="4019">Hypertension NOS </option>
								 <option value="4280">CHF NOS Congestive heart</option>
								 <option value="41401">Crnry athrscl natve vssl</option>
								 <option value="42731">Atrial fibrillation</option>
								 <option value="053">Need prphyl vc vrl hepat</option>
								 <option value="290">NB obsrv suspct infect</option>
								 <option value="3051">Tobacco use disorder</option>
								<option value="78039">Convulsions NEC</option>
								<option value="25000">DMII wo cmp nt st uncntr</option>
								<option value="5849">Acute kidney failure NOS</option>
								<option value="51881">Acute respiratory failure</option>
								<option value="2720">Pure hypercholesterolem</option>
								<option value="5990">Urin tract infection NOS</option>
								<option value="486">Pneumonia, organism NOS</option>
								<option value="2859">Anemia NOS</option>
								<option value="53081">Esophageal reflux</option>
								<option value="389">Unspecified septicemia</option>
								
								<option value="2449">Hypothyroidism NOS</option>
								<option value="7742">Neonat jaund preterm del</option>
								<option value="5070">Food/vomit pneumonitis</option>
								<option value="2724">Hyperlipidemia NEC/NOS</option>
								<option value="2762">Acidosis</option>
								<option value="2851">Ac posthemorrhag anemia</option>
								
								<option value="502">Routine circumcision</option>
								<option value="4240">Mitral valve disorder</option>
								<option value="412">Old myocardial infarct</option>
								<option value="78039">Convulsions NEC</option>
								<option value="2875">Thrombocytopenia NOS</option>
								    
								   
						</select>
						           			   
           			   
           			</div>
           		</div>
                <div class="row" style="margin-top: 20px;margin-bottom: 50px;">
                    <div class="col-sm-3"></div>
           			<div class="col-sm-6">
           			   <button type="button" class="btn btn-default" id="calculateLos" >Calculate LOS</button>
           			   &nbsp;&nbsp;&nbsp;<label id="losValue"></label>
           			</div>
           		</div>
         	</div>
          </div>
        </div>
       </div>
  <input type="hidden" value="${subjectId}"  id="admissionId"> 	
 <jsp:include page="footer.jsp"></jsp:include>
	 
		
</body>
<script type="text/javascript">
 $(document).ready(function(){
	 $('#symptoms').selectpicker();
	 $("#calculateLos").click(function(){
		 $("#losValue").empty().text("Loading...");
		 var admissionId = $("#admissionId").val();
		 var symptoms = $("#symptoms").val();
		  $.ajax({
			  method:"POST",
			  url: "AdmissionsServlet?action=calculateLos",
			  data:{admissionId:admissionId,symptoms:symptoms},
			  success: function(result){
		          $("#losValue").empty().text(result);
		     }
		  });
		});
	 
 });

</script>

</html>