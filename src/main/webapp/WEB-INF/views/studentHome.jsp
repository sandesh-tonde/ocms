<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>OCMS</title>
<!--css-->
 <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" media="all">
 <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" media="all">
<!--css-->

   

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="<c:url value="/resources/js/jquery.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap-3.1.1.min.js"/>" type="text/javascript"></script>

</head>
<body>
	<!--header-->
		<div class="header">
			<div class="header-top">
				<div class="container">
					 <div class="top-left">
						<a href="#"> Help  <i class="glyphicon glyphicon-phone" aria-hidden="true"></i> +0123-456-789</a>
					</div>
					<div class="top-right">
					<ul>
						<li> Sandesh </li>
						<li><a href="login.html">Logout</a></li>
					</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!--header-->
		
		<!--content-->
			<div class="content">
				<div class="products-agileinfo">
						<h2 class="tittle">Header Name</h2>
					<div class="container">
						<div class="product-agileinfo-grids w3l">
							<div class="col-md-3 product-agileinfo-grid">
								<div class="brand-w3l">
									<h3>Brands Filter</h3>
									<ul>
										<li><a href="#">Counselling Procedure </a></li>
										<li><a href="#">Student Information</a></li>
										<li><a href="#">Documentation</a></li>
										<li><a href="#">Online Counselling</a></li>
										<li><a href="#">Seat Status</a></li>
										
									</ul>
								</div>
								
							</div>
							<div id="main-containt" class="col-md-9 product-agileinfon-grid1">
								main content
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
							
							<div class="clearfix"></div>
						</div>
					</div>
				<!--copy-->

</body>
</html>