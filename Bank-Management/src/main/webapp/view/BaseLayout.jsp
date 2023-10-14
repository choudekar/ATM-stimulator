
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <link rel="stylesheet" href="/Bank-Management/resources/css/bootstrap.min.css">
 <link rel="stylesheet" href="/Bank-Management/resources/css/style.css">
  <script src="/Bank-Management/resources/js/jquery.min.js"></script>
  <script src="/Bank-Management/resources/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
    	dateFormat : 'mm/dd/yy',
      changeMonth: true,
      changeYear: true,
      defaultDate:'01/01/1993'
    });
  } );
  
  $( function() {
	    $( "#datepicker1" ).datepicker({
	    	dateFormat : 'mm/dd/yy',
	      changeMonth: true,
	      changeYear: true,
	     
	    });
	  } );
  
 
	$(function() {
		$("#selectall").click(function() {
			$('.case').attr('checked', this.checked);
		});
		$(".case").click(function() {

			if ($(".case").length == $(".case:checked").length) {
				$("#selectall").attr("checked", "checked");
			} else {
				$("#selectall").removeAttr("checked");
			}

		});
	});
</script>
<style>
.footer {
   
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: black;
   color: white;
   text-align: center;
   padding: 15px;
}
</style>
</head>


<body  >


	<tiles:insertAttribute name="header"></tiles:insertAttribute>

	<div id="page">

		<div id="body" style="margin-left: 0">


			<tiles:insertAttribute name="body"></tiles:insertAttribute>

		</div>

	</div>
	
<tiles:insertAttribute name="footer"></tiles:insertAttribute>

</body>
</html>