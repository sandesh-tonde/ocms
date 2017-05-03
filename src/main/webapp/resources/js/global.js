



function uploadFile(){
	var document_type=$("#document_type").val();
	var document_file=$("#document_file").val();
	if(document_file==undefined )
		alert("Please select File");
	else if(document_type==undefined )
		alert("Please Enter File Type");
	else{
		var data = new FormData($('#fileForm')[0]);
		$.ajax({
			type: "POST",
	        url : contextApplicationPath+'/StudentController/uploadDocument',       
	        async: false,
	        data : vcfData,
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
	}
}
function showImagePopup(path){
	var ext = path.split('.').pop().toLowerCase();
	path=contextApplicationPath+path;
	var html="" 
		+ "<div class='modal' id='viewFileId' style='z-index:10000;'>"
        + "    <div class='col-md-13'>"
        + "        <div class='modal-content'>"
        + "            <div class='modal-header'>"
        + "                <input value='x' onClick='hideFilePopup()' type='button' class='close' data-dismiss='modal' aria-hidden='true'>"
        + "                <h4 class='modal-title' id='myModalLabel'><strong>File Details</strong></h4>"
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

function hideFilePopup()
{
	$("#viewFileId").remove();
}