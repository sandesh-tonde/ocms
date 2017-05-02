<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
    <title>Online Counselling Management System</title>
    <%--  <link href="${pageContext.request.contextPath}/resources/homepage.css" rel="stylesheet">  --%>
     <%--   <link href="${pageContext.request.contextPath}/resources/bootstrap.min.css" rel="stylesheet">  --%>
       <meta name="viewport" content="width=device-width, initial-scale=1">
      <script src="${pageContext.request.contextPath}/resources/jquery-1.11.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
    </head>
    <body class="login2background" style="background-color:lavender;">
        <div class="container">  
        <center>
         <div class="row">
            <div><a href="#"><h1><b> Bharati Vidyapeeth College Of Engineering,Pune</b></h1></a></div>
          </div>
          <div class="row">
           <div><a href="#" style="color:sky-blue"><h1><b> Online Counselling Management System</b></h1></a></div>
          </div>
         </center>
             <br/> <br/> <br/>
           <!--  <div class="row"><div>test</div>  </div> -->
          <div class="col-lg-12 col-md-12 col-sm-12 ">
              <div class="row">
                <div class="col-lg-12">
                 <h3><b>Welcome Mr. Mehul </b></h3>
                </div>
              </div>
             <!--  <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                       
                        <hr class="intro-divider">
                        <ul class="list-inline intro-social-buttons">
                            <li>
                                <a href="#" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Information</span></a>
                            </li>
                            <li>
                                <a href="#" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Counselling Procedure</span></a>
                            </li>
                            <li>
                                <a href="#" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Documentation</span></a>
                            </li>
                           
                        </ul>
                    </div>
                    <div class="intro-message">
                       
                        <ul class="list-inline intro-social-buttons">
                             <li>
                                <a href="ocms" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Online Counselling</span></a>
                             </li>
                             <li>
                                <a href="#" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Seat Status</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div> -->
                
            </div>  
          
           <br/> <br/> 
         <div class=" col-lg-3 col-md-3 col-sm-3">  
          <div class="row"> 
           <div class="sidebar-nav">
			    <div class="well" style="width:200px; padding: 8px 0;">
					<ul class="nav nav-list"> 
					 <!--  <li class="nav-header">Admin Menu</li>     -->    
			          <li class="active"><a href="#" onclick="conselling_proc()"><i class="icon-envelope"></i> Counselling Procedure </a></li>
			           <li><a href="${pageContext.request.contextPath}/getStudentInfo"><i class="icon-home"></i>Student Information</a></li>
			          <li><a href="#"><i class="icon-comment"></i> Documentation </a></li>
					  <li ><a href=${pageContext.request.contextPath}/ocms><i class="icon-user"></i> Online Counselling</a></li>
					  <li><a href=${pageContext.request.contextPath}/seatstatus><i class="icon-comment"></i> Seat Status</a></li>
					  <li><a href="logout"><i class="icon-share"></i> Logout</a></li>
					</ul>
				</div>
		    </div>
		   </div>
		  </div>
		  
		  
		    <!-- ---------  counselling procedure    --> 
              
              <div id="conprocid" class="row">
               <div class="col-lg-8 col-md-8 col-sm-8">
                  <h4>Candidate should select the counselling venue from the list of centres available in the online test booking system before they download the e-hall ticket.
					The rank, counselling schedule, venue and other relevant details, will be made available in the website www.admissions.manipal.edu along with the announcement of results. Candidates should ensure that they fulfill all the eligibility requirements mentioned in the prospectus before they report for counselling. Only the candidates whose ranks are included in the counselling schedule are required to attend the counselling.
						The physical presence of the candidate at the counselling is mandatory. If a candidate is prevented by unavoidable circumstances from being physically present for the counselling, he/she may authorize another individual to represent him/her at the counselling. This representative must carry the authorization in a format, CLICK HERE for format and bring all the documents and the full fees. Absence of the candidate or his/her representative at the indicated reporting time and date will result in the instantaneous forfeiture of any claim for a seat.
					Only the candidate/representative will be allowed into the counselling hall. They will be called in the order of their ranks and offered the seats available at that point of time. They are permitted to choose any of the seats available during their turn. Ties will be resolved in the manner described below:
					The Net Average Score (NAS) obtained during the qualifying examination will be calculated by taking the gross average marks of all the Board / University examinations and subtracting a factor determined on the basis of the number of failures. The tied candidates will be re-ranked on the basis of NAS.
					In the event of NAS of two (or more) tied candidates being identical, the candidate with fewer failures will be ranked higher.
					For the purpose of this rule, each failure in a subject in a (semester/year) Board/University examination will be reckoned as one failure. Non-appearance in a particular subject in an examination for whatever reason will also be counted as failure.
					Successful candidates will be allotted seats according to their rank and number of seats available. The choice of course made by the candidate / representative is final and binding and cannot be altered later under any circumstances. 
				  </h4>
              </div>
             </div>
             
              <!-- ---------  counselling procedure    --> 
              
          <!-- --------- Online Counselling    -->
           <c:if test="${user!=null}"> 
            <script type="text/javascript">
               $('#conprocid').hide();
          	   $('#seatstatusid').hide(); 
          	   $('#infodivid').hide(); 
              </script>
            <div id="ocdivid" class="col-lg-8 col-md-8 col-sm-8">
                  <div class="table-responsive">          
					 <table class="table table-bordered table-condensed">
					   <thead>
					     <tr>
					       <th>Name</th>
					       <th>Rank</th>
					       <th>Age</th>
					       <th>City</th>
					       <th>Country</th>
					       <th>Counselling Date</th>
					       <th>University Seat No.</th>
					     </tr>
					   </thead>
					   <tbody>
					     <tr>
					   
					    <%--  <c:forEach items="${user}" var="user"> --%>
					       <td>${user.name}</td>
					       <td>${user.rank}</td>
					       <td>${user.age}</td>
					       <td>${user.city}</td>
					       <td>${user.country}</td>
					       <td>${user.counselling_date}</td>
					       <td>${user.seat_no}</td>
					       <%-- </c:forEach> --%>
					      
					     </tr>
					   </tbody>
					 </table>   
                </div>
              
              <div class="row">
              <%--  <div class="col-lg-5 col-md-5 col-sm-5">
                  <div class="table-responsive">          
					 <table class="table table-bordered table-condensed">
					   <thead>
					     <tr>
					       <th>Sr.No</th>
					       <th>Branch Name</th>
					       <th>Total Seats</th>
					       <th>Available Seats</th>
					     </tr>
					   </thead>
					   <tbody id="branchtableid">
					   <c:if test="${branch!=null}"> 
			            <c:forEach items="${branch}" var="branch" varStatus="loopCounter">
			              <tr>
					      <td> ${loopCounter.count}</td>
					      <td> ${branch.branch_name}</td>
					      <td> ${branch.seats}</td>
					      <td> ${branch.available_seats}</td>
					      </tr>
					      
			            </c:forEach>
		              </c:if>
					   </tbody>
					 </table>   
                </div>
              </div> --%>
              
              
               <div class="col-lg-5 col-md-5 col-sm-5">
               <form  method="post" action="submitPreferences">
                  <div class="table-responsive">          
					 <table class="table table-bordered table-condensed">
					   <thead>
					     <tr>
					       <th>Sr.No.</th>
					       <th>Preferences</th>
					     </tr>
					   </thead>
					   <tbody>
					   <c:forEach var="i" begin="1" end="3">
					     <tr>
					       <td>${i}</td>
				           <td>   
				             <select name="option${i}" id="option${i}">
				              <option id="${i}0" value="0">--Select Branch--</option>
				              <c:if test="${branch!=null}"> 
			                   <c:forEach items="${branch}" var="branch" varStatus="loopCounter">
								  <option id="${branch.branch_id}${i}" onclick="checkHideOtherBranch(${branch.branch_id},${i})" value="${branch.branch_id}">${branch.branch_name}</option>
							   </c:forEach>
		                    </c:if>
							</select>           
						  </td>
					     </tr>
					    </c:forEach>
					   </tbody>
					 </table>   
                </div>
                <div><center><button type="submit">Submit</button> <button type="reset">Reset</button></center></div>
             </form>
             </div>
            </div>
            </div>
           </c:if>   
          <!-- --------- Online Counselling    -->
             
          <!-- --------- Seat status    --> 
           <c:if test="${seatbranch!=null}"> 
             <script type="text/javascript">
               $('#conprocid').hide();
        	   $('#ocdivid').hide(); 
        	   $('#infodivid').hide(); 
              </script>
              <div id="seatstatusid" class="row">
               <div class="col-lg-5 col-md-5 col-sm-5">
                  <div class="table-responsive">          
					 <table class="table table-bordered table-condensed">
					   <thead>
					     <tr>
					       <th>Sr.No</th>
					       <th>Branch Name</th>
					       <th>Total Seats</th>
					       <th>Available Seats</th>
					     </tr>
					   </thead>
					   <tbody id="seatbranchtableid">
					   <c:if test="${seatbranch!=null}"> 
			            <c:forEach items="${seatbranch}" var="branch" varStatus="loopCounter">
			              <tr>
					      <td> ${loopCounter.count}</td>
					      <td> ${branch.branch_name}</td>
					      <td> ${branch.seats}</td>
					      <td> ${branch.available_seats}</td>
					      </tr>
					      
			            </c:forEach>
		              </c:if>
					   </tbody>
					 </table>   
                </div>
              </div>
             </div>
              </c:if>
              <!-- ---------  Seat status    --> 
              
               <!-- --------- student information    -->
           <c:if test="${student!=null}"> 
            <script type="text/javascript">
               $('#conprocid').hide();
          	   $('#seatstatusid').hide(); 
          	   $('#ocdivid').hide();
              </script>
               <div id="infodivid" class="col-lg-8 col-md-8 col-sm-8">
                  <div class="table-responsive">          
					 <table class="table table-condensed table-bordered table-hover" style="width:50%;text-align:center;">
					  
				       <tr><td >Name</td><td>${student.name}</td> </tr>
				       <tr><td>Rank</td><td>${student.rank}</td></tr>
				       <tr><td >Age</td><td>${student.age}</td></tr>
				       <tr> <td>City</td><td>${student.city}</td></tr>
				       <tr> <td>Country</td><td>${student.country}</td></tr>
				       <tr><td>Counselling Date</td><td>${student.counselling_date}</td></tr>
				       <tr><td >University Seat No.</td><td>${student.seat_no}</td></tr>
					  
					 </table>   
                </div>
               </div>
              </c:if> 
             <!-- ---------  student information    -->
                
                
             <script type="text/javascript">
             function conselling_proc(){ 
            	 $('#seatstatusid').hide(); 
            	 $('#ocdivid').hide(); 
            	 $('#infodivid').hide(); 
            	 $('#conprocid').show(); 
            	 
             }
             
              function checkHideOtherBranch(id,i){
            	 
            	  if(i==2 && $("#option1").val()==0){
            		  alert("select 1st option");
            		  $("#option"+i+" option:selected").prop("selected", false);
            		  $("#option"+i+" option:first").prop("selected", "selected");
            		  $("#option"+i+"").val=0;
            		  alert( $("#option"+i+"").val())
            	   }
            	   else if(i==3 && $("#option1").val()==0){
            			  alert("select 1st option");
            			  $("#option"+i+" option:selected").prop("selected", false);
                		  $("#option"+i+" option:first").prop("selected", "selected");
                		  $("#option"+i+"").val=0;
                		  alert( $("#option"+i+"").val())
            	     }
            	     else if(i==3 && $("#option2").val()==0){
                			  alert("select 2nd option");
                		$("#option"+i+" option:selected").prop("selected", false);
                    	$("#option"+i+" option:first").prop("selected", "selected");
                    	 $("#option"+i+"").val=0;
                    	 alert( $("#option"+i+"").val())
            	     }
            	     else{	  
            		 
            	     if(i==2){
                 	   i++;
                	   $("#"+id+""+i+"").hide(); 
                	 }
            	     else if(i==1){
		           	 i++;
		           	 $("#"+id+""+i+"").hide();
		           	 i++;
		           	 $("#"+id+""+i+"").hide(); 
            	    } 
               }
             } 
             </script>
             
        </div>
    </body>
</html>
