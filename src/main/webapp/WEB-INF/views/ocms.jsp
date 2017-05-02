<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
    <title>Online Counselling Management System</title>
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body class="login2background">
        <div class="container">  
        <center>
           <div class="row">
            <div><a href="#"><h1><b> Bharati Vidyapeeth College Of Engineering,Pune</b></h1></a></div>
          </div>
          <div class="row">
           <div><a href="#" style="color:sky-blue"><h1><b> Online Counselling Management System</b></h1></a></div>
          </div>
         </center>
             <br/>
            
            <div class="col-lg-12 col-md-12 col-sm-12 ">
            
              <div class="row">
                <div class="col-lg-12">
                 <h3><b>Welcome Mr. Mehul </b></h3>
                </div>
              </div>
               <div class="row">
                <div class="col-lg-12">
                 <h3></h3>
                </div>
              </div>
              <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
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
					       <td>Mehul</td>
					       <td>A1</td>
					       <td>35</td>
					       <td>New York</td>
					       <td>USA</td>
					       <td>29 March 2016</td>
					       <td>p34556566</td>
					     </tr>
					   </tbody>
					 </table>   
                </div>
               </div>
               
             </div>
              <div class="row">
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
					   <tbody>
					     <tr>
					       <td>1</td>
					       <td>Computer</td>
					       <td>35</td>
					       <td>32</td>
					     </tr>
					      <tr>
					       <td>2</td>
					       <td>Information Technology</td>
					       <td>35</td>
					       <td>32</td>
					     </tr>
					      <tr>
					       <td>3</td>
					       <td>Electronics</td>
					       <td>35</td>
					       <td>32</td>
					     </tr>
					      <tr>
					       <td>4</td>
					       <td>Electrical</td>
					       <td>35</td>
					       <td>32</td>
					     </tr>
					      <tr>
					       <td>5</td>
					       <td>Mechanical</td>
					       <td>35</td>
					       <td>32</td>
					     </tr>
					      <tr>
					       <td>6</td>
					       <td>Civil</td>
					       <td>35</td>
					       <td>32</td>
					     </tr>
					   </tbody>
					 </table>   
                </div>
              </div>
               <div class="col-lg-1 col-md-1 col-sm-1"></div>
               <div class="col-lg-3 col-md-3 col-sm-3">
               <form  method="post">
                  <div class="table-responsive">          
					 <table class="table table-bordered table-condensed">
					   <thead>
					     <tr>
					       <th>Sr.No.</th>
					       <th>Branch</th>
					     </tr>
					   </thead>
					   <tbody>
					     <tr>
					       <td>1</td>
				           <td>   
				             <select name="option1" required>
				              <option>--Select--</option>
							  <option value="1">Computer</option>
							  <option value="2">Information Technology</option>
							  <option value="3">Civil</option>
							  <option value="4">Mechanical</option>
							   <option value="5">Electrical</option>
							  <option value="6">Electronics</option>
							 </select>           
						  </td>
					     </tr>
					      <tr>
					       <td>2</td>
					       <td>
					       <select name="option2" required>
					           <option>--Select--</option>
							  <option value="1">Computer</option>
							  <option value="2">Information Technology</option>
							  <option value="3">Civil</option>
							  <option value="4">Mechanical</option>
							   <option value="5">Electrical</option>
							  <option value="6">Electronics</option>
							 </select>   
					       </td>
					     </tr>
					      <tr>
					       <td>3</td>
					       <td>
					         <select name="option3" required>
					         <option>--Select--</option>
							  <option value="1">Computer</option>
							  <option value="2">Information Technology</option>
							  <option value="3">Civil</option>
							  <option value="4">Mechanical</option>
							   <option value="5">Electrical</option>
							  <option value="6">Electronics</option>
							 </select>   
					       </td>
					     </tr>
					 
					   </tbody>
					 </table>   
                </div>
                <div><center><button type="submit">Submit</button> <button type="reset">Reset</button></center></div>
            </form>
           </div>
              </div>
            </div>
           <!--  <div class="col-lg-6 col-md-6 col-sm-4 "></div> -->
         
             <!-- <div class="alert alert-danger text-center"> <h5>Login failed..Invalid username or password!!! </h5></div>  -->    
        </div>
    </body>
</html>
