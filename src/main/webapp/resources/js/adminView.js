function homeView() {
	var html = '<h2 id="h2.-bootstrap-heading">Home</h2>'
		+ '<h2>'
		+ '		<a href="#" onclick="getStudentBatchWise(1)"><span class="label label-default">Batch1</span></a>'
		+ '		<a href="#" onclick="getStudentBatchWise(2)"><span class="label label-default">Batch2</span></a>'
		+ '		<a href="#" onclick="getStudentBatchWise(3)"><span class="label label-default">Batch3</span></a>'
		+ '</h2>'
		+ '<h3 class="hdg">Set Time Slot</h3>'
		+ '<div class="container" style="width:80%">'
		+ '<div class="col-md-5">'
		+ '    <div class="form-group">'
		+ '        <div class="input-group date" id="startDate">'
		+ '            <input type="text"  placeholder="Start Date"  id="sDate"class="form-control" />'
		+ '            <span class="input-group-addon">'
		+ '                <span class="glyphicon glyphicon-calendar"></span>'
		+ '            </span>'
		+ '        </div>'
		+ '    </div>'
		+ '</div>'
		+ '<div class="col-md-5">'
		+ '    <div class="form-group">'
		+ '        <div class="input-group date" id="endDate">'
		+ '            <input type="text"  placeholder="End Date"  id="eDate" class="form-control" />'
		+ '            <span class="input-group-addon">'
		+ '                <span class="glyphicon glyphicon-calendar"></span>'
		+ '            </span>'
		+ '        </div>'
		+ '    </div>'
		+ '</div>'
		+ '<div class="col-md-5">'
		+ '    <div class="form-group">'
		+ '		<button type="button" class="btn btn-primary m-b-10" style=" margin-left: 90%" onclick="setTime()">Set Time</button></td>'
		+ '    </div>'
		+ '</div>'
		+ '</div>'
		+ '<table class="table table-bordered">'
		+ '<thead>'
		+ '	<tr>'
		+ '		<th>Name</th>'
		+ '		<th>Rank</th>'
		+ '		<th>Seat No.</th>'
		+ '		<th>Councelling Date</th>'
		+ '		<th>Start Time</th>'
		+ '		<th>End Time</th>'
		+ '		<th>Result</th>'
		+ '	</tr>'
		+ '</thead>'
		+ '<tbody id="studentsData">'

		+ '</tbody>'
		+ '</table>';
	$("#main-containt").empty();
	$("#main-containt").html(html);
	
    $(function () {
        $('#startDate').datetimepicker();
        $('#endDate').datetimepicker({
            useCurrent: false //Important! See issue #1075
        });
        $("#startDate").on("dp.change", function (e) {
            $('#endDate').data("DateTimePicker").minDate(e.date);
        });
        $("#endDate").on("dp.change", function (e) {
            $('#startDate').data("DateTimePicker").maxDate(e.date);
        });
    });


	getStudentBatchWise(1);
	
}

function getStudentBatchWise(batch){
	$.ajax({
		type: "POST",
        url : contextApplicationPath+'/AdminController/getBatchWiseUserDetails',         
        data : {"batch" : batch},
        dataType: 'json',
        success : function(json) {
        	 var html='';
        	
			var i=0;
				$(json).each(function(index, element) {
					if (element.name != undefined) {
						i++;
					html += '	<tr>'
						+ '		<td>' + element.name + '<input type="hidden" id="userId_'+i+'" value="'+element.id+'"></td>'
						+ '		<td>' + element.rank + '</td>'
						+ '		<th>' + element.seatNo + '</th>'
						+ '		<th>' + element.councellingDate + '</th>'
						+ '		<th>' + element.startTime + '</th>'
						+ '		<th>' + element.endTime + '</th>'
						+ '		<th>' + element.result + '</th>'
						+ '	</tr>';
					}
				});
			
			$("#studentsData").html(html);
        },
        error : function(json) {
        	alert("some error");	  
        }       
    });	
}

function setTime(){
	var startDate=$('#sDate').val();
	var EndDate=$('#eDate').val();
	if(startDate=="" || EndDate==""){
		alert("please select time slot");
		return;
	}
	var userId=[];
	for(var i=1 ;i<60; i++){
		if($("#userId_"+i).val() != undefined){
			userId.push($("#userId_"+i).val());
		}
	}
	console.log("userId="+userId);
	$.ajax({
		type: "POST",
        url : contextApplicationPath+'/AdminController/setUserTimeSlot',         
        data : {"startDAte" : startDate ,"endDate" :EndDate ,"userId":userId.toString()},
        dataType: 'json',
        success : function(json) {
        	//$(json).each(function(index, element) {});
			alert("Time Slot Updated");
			homeView();
        },
        error : function(json) {
        	alert("some error");	  
        }       
    });		
}

function resultView() {
	

	var html = '<h2 id="h2.-bootstrap-heading">Result</h2>'
		+ '<h2>'
		+ '		<a href="#" onclick="getStudentBatchWise(1)"><span class="label label-default">Batch1</span></a>'
		+ '		<a href="#" onclick="getStudentBatchWise(2)"><span class="label label-default">Batch2</span></a>'
		+ '		<a href="#" onclick="getStudentBatchWise(3)"><span class="label label-default">Batch3</span></a>'
		+ '</h2>'
		//+ '<h3 class="hdg">create Result</h3>'
		+ '<div class="container" style="width:80%">'
		
		+ '<div class="col-md-5">'
		+ '    <div class="form-group">'
		+ '		<button type="button" class="btn btn-primary m-b-10" style=" margin-left: 90%" onclick="result()">Create Result</button></td>'
		+ '    </div>'
		+ '</div>'
		+ '</div>'
		+ '<table class="table table-bordered">'
		+ '<thead>'
		+ '	<tr>'
		+ '		<th>Name</th>'
		+ '		<th>Rank</th>'
		+ '		<th>Seat No.</th>'
		+ '		<th>Councelling Date</th>'
		+ '		<th>Start Time</th>'
		+ '		<th>End Time</th>'
		+ '		<th>Result</th>'
		+ '	</tr>'
		+ '</thead>'
		+ '<tbody id="studentsData">'

		+ '</tbody>'
		+ '</table>';
	$("#main-containt").empty();
	$("#main-containt").html(html);
	
	getStudentBatchWise(1);
	
}

function result(){
	var userId=[];
	for(var i=1 ;i<60; i++){
		if($("#userId_"+i).val() != undefined){
			userId.push($("#userId_"+i).val());
		}
	}
	console.log("userId="+userId);
	$.ajax({
		type: "POST",
        url : contextApplicationPath+'/AdminController/result',         
        data : {"userId":userId.toString()},
        dataType: 'json',
        success : function(json) {
        	//$(json).each(function(index, element) {});
			alert("Result Generated");
			resultView();
        },
        error : function(json) {
        	alert("some error");	  
        }       
    });		
}

function adminDocumentView() {
	var html = '<h2 id="h2.-bootstrap-heading">Document Varification</h2>'
		+ '<h2>'
		+ '		<a href="#" onclick="getDocumentBatchWise(1)"><span class="label label-default">Batch1</span></a>'
		+ '		<a href="#" onclick="getDocumentBatchWise(2)"><span class="label label-default">Batch2</span></a>'
		+ '		<a href="#" onclick="getDocumentBatchWise(3)"><span class="label label-default">Batch3</span></a>'
		+ '</h2>'
		//+ '<h3 class="hdg">create Result</h3>'
		+ '<div class="container" style="width:80%">'
		+ '<table class="table table-bordered">'
		+ '<thead>'
		+ '	<tr>'
		+ '		<th>Name</th>'
		+ '		<th>Rank</th>'
		+ '		<th>Seat No.</th>'
		+ '		<th>Document 1</th>'
		+ '		<th>Document 2</th>'
		+ '		<th>Document 3</th>'
		+ '	</tr>'
		+ '</thead>'
		+ '<tbody id="studentsData">'

		+ '</tbody>'
		+ '</table>';
	$("#main-containt").empty();
	$("#main-containt").html(html);
	
	getDocumentBatchWise(1);
	
}

function getDocumentBatchWise(batch){

	$.ajax({
		type: "POST",
        url : contextApplicationPath+'/AdminController/getBatchWiseUserDetails',         
        data : {"batch" : batch},
        dataType: 'json',
        success : function(json) {
        	 var html='';
        	
			var i=0;
				$(json).each(function(index, element) {
					if (element.name != undefined) {
						i++;
					html += '	<tr>'
						+ '		<td>' + element.name + '<input type="hidden" id="userId_'+i+'" value="'+element.id+'"></td>'
						+ '		<td>' + element.rank + '</td>'
						+ '		<th>' + element.seatNo + '</th>';
					    var data=element.docArray;
					    var i=0;
					    $(data).each(function(index, elem) {
					    	i++;
					    	html +="<td>"
					    		
					    			+"<img src='"+contextApplicationPath+"/resources/images/fileIcon.png' style='width:50px;height:50px;' onClick='showImagePopupAdmin(\""+elem.docId+"\",\""+elem.path+"\")'>"
					    			+elem.type
					    		
					    		 +"</td>";
					    		
					    });
					    while(i<3){
					    	html +="<td></td>";
					    	i++;
					    }
						+ '	</tr>';
					}
				});
			
			$("#studentsData").html(html);
        },
        error : function(json) {
        	alert("some error");	  
        }       
    });	
	
}

function showImagePopupAdmin(id,path){

	var ext = path.split('.').pop().toLowerCase();
	path=contextApplicationPath+path;
	var app ="Approve";
	var diapp ="Disapprove";
	var html="" 
		+ "<div class='modal' id='viewFileId' style='z-index:10000;'>"
        + "    <div class='col-md-13'>"
        + "        <div class='modal-content'>"
        + "            <div class='modal-header'>"
        + "                <input value='x' onClick='hideFilePopup()' type='button' class='close' data-dismiss='modal' aria-hidden='true'>"
        + "                <h4 class='modal-title' id='myModalLabel'><strong>File Details</strong></h4>"
        + '<h2>'
		+ "		<a href='#' onclick='documentVarification(\""+app+"\")'><span class='label label-default'>Approve</span></a>"
		+ "		<a href='#' onclick='documentVarification(\""+diapp+"\")'><span class='label label-default'>DisApprove</span></a>"
		+ '</h2>'
        + "            </div>"
        + "			       <div class='panel-body'>"
        + "    			        <div class='row'>"
        +" 							<div class='col-md-12 col-sm-12 col-xs-12 table-responsive'>";
		html+="<object data='"+path+"' alt='Smiley face' height='480px' width='100%'></object>";
		html+="							</div>"
		+ "						</div>"
        + "            		</div>"
        + "        </div>"
        + "    </div>"
        + "</div>";
	 $("#ViewImagesPopUp").html(html);
	 $("#viewFileId").addClass("in");
	 $("#viewFileId").attr("aria-hidden","false");
	 $("#viewFileId").css("display","block");

}

function documentVarification(status){
	alert(status);
	
}
function adminBranchView() {

	$.ajax({
		type: "POST",
        url : contextApplicationPath+'/StudentController/getBranchesDetails',         
        data : {},
        dataType: 'json',
        success : function(json) {
        	var html='<h2 id="h2.-bootstrap-heading">Seat Status</h2><br><br>'
        		+'<table class="table">'
				+'<thead>'
				+'	<tr>'
				+'		<th>No</th>'
				+'		<th>Branch</th>'
				+'		<th>Seats</th>'
				
				+'	</tr>'
				+'</thead>'
				+'<tbody>';
        	$(json).each(function(index, element) {
        		
        		html +='	<tr>'
				+'		<td>'+index+'</td>'
				+'		<td>'+element.branchName+'</td>'
				+'		<td>'+element.availableSeats+'</td>'
				+'	</tr>';
				
        		
			}); 
        	
        	html +='</tbody>'
			+'</table>';
        	
        	       	
        	$("#main-containt").empty();
			$("#main-containt").html(html);
			
        },
        error : function(json) {
        	alert("some error");	  
        }       
    });	

}