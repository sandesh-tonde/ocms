




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