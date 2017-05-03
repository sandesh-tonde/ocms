<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>OCMS</title>
<!--css-->
 <link  href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
 <link  href="<c:url value="/resources/css/font-awesome.css" /> rel="stylesheet">
 <link  href="<c:url value="/resources/css/style.css" />" rel="stylesheet" media="all">
 <link  href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" media="all">
<!--css-->

   

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
contextApplicationPath = "${pageContext.request.contextPath}";
</script>
<script src="<c:url value="/resources/js/jquery.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap-3.1.1.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/studentView.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/global.js"/>" type="text/javascript"></script>

</head>
<body onload="councellingProcedureView()">
	<!--header-->
		<div class="header">
			<div class="header-top">
				<div class="container">
					 <div class="top-left">
						<a href="#"> Help  <i class="glyphicon glyphicon-phone" aria-hidden="true"></i> +0123-456-789</a>
					</div>
					<div class="top-right">
					<ul>
						<li><a href="#"> <%=request.getSession().getAttribute("user_name")%></a></li>
						<li><a href="${pageContext.request.contextPath}/LoginController/logout">Logout</a></li>
					</ul>
					</div>
					
				</div>
			</div>
		</div>
		<!--header-->
		
		<!--content-->
			<div class="content">
				<div class="products-agileinfo">
						<h2 class="tittle"> Bharati Vidyapeeth College Of Engineering,Pune</h2>
						<h2 class="tittle"> Online Counselling Management System</h2>
					<div class="container">
						<div class="product-agileinfo-grids w3l">
							<div class="col-md-3 product-agileinfo-grid">
								<div class="brand-w3l">
									<h3>Action</h3>
									<ul>
										<li><a href="#" onclick="councellingProcedureView()">Counselling Procedure </a></li>
										<li><a href="#" onclick="studentInformationView()">Student Information</a></li>
										<li><a href="#" onclick="">Documentation</a></li>
										<li><a href="#" onclick="">Online Counselling</a></li>
										<li><a href="#" onclick="">Seat Status</a></li>
										
									</ul>
								</div>
								
							</div>
							<div id="main-containt" class="col-md-9 product-agileinfon-grid1">
								
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
			</div>
		<!--content-->
		
					<!--copy-->
					<div class="copy-section">
						<div class="container">
							<div class="copy-left">
								<p>&copy; 2017 OCMS . All rights reserved </p>
							</div>
							
							
						</div>
					</div>
				<!--copy-->

</body>
</html>