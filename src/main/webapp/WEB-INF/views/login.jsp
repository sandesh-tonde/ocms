<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
     <title>Online Counselling Management System</title>
        
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/homepage.css" rel="stylesheet">
   
   <script src="<c:url value="/resources/js/jquery.js"/>" type="text/javascript"></script>
   <script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>
   <script src="<c:url value="/resources/js/jquery-migrate.js"/>" type="text/javascript"></script>
   
   
       <script type="text/javascript">         	   
			function disableBackButton(){window.history.forward();}
			setTimeout("disableBackButton()", 0);
			contextApplicationPath = "${pageContext.request.contextPath}";
	  </script>
    </head>
    <body  class="login2background" background="<c:url value="/resources/images/main-background.png"/>">
        <div class="container">  
        <center><br><br><br>
         <div class="col-lg-12 col-md-12 col-sm-12">
           <div class="row">
            <div><a href="#"><h1><b> Bharati Vidyapeeth College Of Engineering,Pune</b></h1></a></div>
           </div><br><br><br>
           <div class="row">
            <div><a href="#" style="color:sky-blue"><h1><b> Online Counselling Management System</b></h1></a></div>
           </div>
         </div>
         </center>
            <div class="col-lg-6 col-md-6 col-sm-8  loginbox">
                <div class=" row">
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-6">
                        <img src="<c:url value="/resources/images/logo_3.png"/>" alt="Logo" class="logo"> 
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6  ">
                        <span class="singtext" >Sign in </span>   
                    </div>
                                 
                </div>
               <form action="${pageContext.request.contextPath}/LoginController/login"  method="post">
                <div class=" row loginbox_content "> 
                        <% if(request.getAttribute("msg")!=null){%>
                        <br><div id="loginmsg" class="alert alert-danger text-center"> <h5> <%=request.getAttribute("msg") %></h5></div>
                        <%} %>                  
                    <div class="input-group input-group-sm" >
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-user"></span>
                        </span>
                        <input class="form-control" name="username" onclick="hideLoginmsg()" type="text" placeholder="User name"  required>
                    </div>
                    <br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-lock"></span>
                        </span>
                        <input class="form-control" name="password" onclick="hideLoginmsg()" type="password" placeholder="Password" required>
                    </div>              
                </div>
                <div class="row ">                   
                   
                    <div class="col-lg-6 col-md-6 col-sm-6  col-xs-6 ">                        
                    <button type="submit" class="btn btn-primary submit-btn">Submit</button> 
                    </div>
                     <div class="col-lg-6 col-md-6  col-sm-6 col-xs-6  "> 
                       <button type="reset" class="btn btn-success">Reset</button>                      
                    </div>
                </div>
              </form>  
                
            </div>
            <div class="col-lg-6 col-md-6 col-sm-4 "></div>

            <script type="text/javascript">
            function hideLoginmsg(){
            	$("#loginmsg").hide();
            }
            </script>
              <% if(request.getAttribute("msg")!=null){%>
                 <script type="text/javascript">
                 alert(request.getAttribute("session"));
                  </script>
               <%} %> 
        </div>
    </body>
</html>
