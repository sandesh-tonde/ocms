function homeView() {
	var html = '<h2 id="h2.-bootstrap-heading">Student Information</h2>'
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

}
function adminDocumentView() {

}
function adminBranchView() {

}