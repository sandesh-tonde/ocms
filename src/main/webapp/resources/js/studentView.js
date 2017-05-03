function councellingProcedureView(){
	var html="<h2 id='<h2.-bootstrap-heading'>Councelling Procedure</h2><br><br>" 
			+"<div class='well'>"
			+"Candidate should select the counselling venue from the list of centres available in the online test booking system before they download the e-hall ticket."
			+"The rank, counselling schedule, venue and other relevant details, will be made available in the website www.admissions.manipal.edu along with the announcement of results. "
			+"Candidates should ensure that they fulfill all the eligibility requirements mentioned in the prospectus before they report for counselling. "
			+"Only the candidates whose ranks are included in the counselling schedule are required to attend the counselling."
			+"The physical presence of the candidate at the counselling is mandatory. If a candidate is prevented by unavoidable circumstances from being physically present for the counselling, "
			+"he/she may authorize another individual to represent him/her at the counselling. This representative must carry the authorization in a format, CLICK HERE for format and bring all the documents and the full fees. "
			+"Absence of the candidate or his/her representative at the indicated reporting time and date will result in the instantaneous forfeiture of any claim for a seat."
			+"Only the candidate/representative will be allowed into the counselling hall. They will be called in the order of their ranks and offered the seats available at that point of time. "
			+"They are permitted to choose any of the seats available during their turn. Ties will be resolved in the manner described below:"
			+"The Net Average Score (NAS) obtained during the qualifying examination will be calculated by taking the gross average marks of all the Board / University examinations and subtracting a factor determined on the basis of the number of failures."
			+"The tied candidates will be re-ranked on the basis of NAS."
			+"In the event of NAS of two (or more) tied candidates being identical, the candidate with fewer failures will be ranked higher."
			+"For the purpose of this rule, each failure in a subject in a (semester/year) Board/University examination will be reckoned as one failure. Non-appearance in a particular subject in an examination for whatever reason will also be counted as failure."
			+"Successful candidates will be allotted seats according to their rank and number of seats available. The choice of course made by the candidate / representative is final and binding and cannot be altered later under any circumstances."
			+"</div>"
			$("#main-containt").empty();
			$("#main-containt").html(html);
}

function studentInformationView(){
	$.ajax({
		type: "POST",
        url : contextApplicationPath+'/StudentController/getUserDetails',         
        data : {},
        dataType: 'json',
        success : function(json) {
        	$(json).each(function(index, element) {
        		var html='<h2 id="h2.-bootstrap-heading">Student Information</h2><br><br>'
        		+'<table class="table table-bordered">'
				+'<thead>'
				+'	<tr>'
				+'		<th>Name</th>'
				+'		<th>Rank</th>'
				+'		<th>Age</th>'
				+'		<th>City</th>'
				+'		<th>country</th>'
				+'		<th>Seat No.</th>'
				+'		<th>Councelling Date</th>'
				+'		<th>Start Time</th>'
				+'		<th>End Time</th>'
				+'	</tr>'
				+'</thead>'
				+'<tbody>'
				+'	<tr>'
				+'		<td>'+element.name+'</td>'
				+'		<td>'+element.rank+'</td>'
				+'		<td>'+element.age+'</td>'
				+'		<td>'+element.city+'</td>'
				+'		<th>'+element.country+'</th>'
				+'		<th>'+element.seatNo+'</th>'
				+'		<th>'+element.councellingDate+'</th>'
				+'		<th>'+element.startTime+'</th>'
				+'		<th>'+element.endTime+'</th>'
				+'	</tr>'
				+'</tbody>'
				+'</table>'
        		$("#main-containt").empty();
    			$("#main-containt").html(html);
			}); 
        },
        error : function(json) {
        	alert("some error");	  
        }       
    });	
}

function documentationView(){
	$.ajax({
		type: "POST",
        url : contextApplicationPath+'/StudentController/getDocumentsDetails',         
        data : {},
        dataType: 'json',
        success : function(json) {
        	var html='<h2 id="h2.-bootstrap-heading">Documents</h2><br><br>'
        		+'<table class="table">'
				+'<thead>'
				+'	<tr>'
				+'		<th>Document Type</th>'
				+'		<th>File</th>'
				
				+'	</tr>'
				+'</thead>'
				+'<tbody>';
        	$(json).each(function(index, element) {
        		
        		html +='	<tr>'
				+'		<td>'+element.type+'cc'
				+"<td><img src='"+contextApplicationPath+"/resources/images/fileIcon.png' style='width:50px;height:50px;' onClick='showImagePopup(\""+element.path+"\")'></td>"
				+'	</tr>';
				
        		
			}); 
        	
        	html +='</tbody>'
			+'</table>';
        	
        	if ((json.length) < 3){
        		html +='<form id="fileForm" action ="'+contextApplicationPath+'/StudentController/uploadDocument" method="post" enctype="multipart/form-data" >'
        			+'<table class="table">'
        			+'	<tr>'
        			+'		<td><input type= "text" id = "document_type"  name="document_type" /></td>'
    				+'		<td><input type= "file" id = "document_file" name="document_file"/><br>'
    				+'		<input type= "submit" class="btn btn-primary m-b-10" onclick="return validate()" value="upload"></td>'
    				+'</tr>'
    				+'</table>'
    				+'</form>';
        	}
        	
        	$("#main-containt").empty();
			$("#main-containt").html(html);
        },
        error : function(json) {
        	alert("some error");	  
        }       
    });	
	
}

function validate(){
	
	
	myFormData.append('document_type', document_type);
	if(document_file==undefined ){
		alert("Please select File");
		return false;
	}
	else if(document_type==undefined ){
		alert("Please Enter File Type");
		return false;
	}
	else{
		return true;
		/*
		var data = new FormData($('#fileForm')[0]);
		$.ajax({
			type: "POST",
	        url : contextApplicationPath+'/StudentController/uploadDocument',       
	        async: false,
	        data : data,
	        dataType: 'json',
	       // processData: false,
	        //contentType: false,
	       // cache : false,
	        success : function(json) 
	        {
	        	state = false;
	        	$(json).each(function(index, element) {
	        		alert(element.msg);
	        	}); 
	        }
	    });
	*/}
}