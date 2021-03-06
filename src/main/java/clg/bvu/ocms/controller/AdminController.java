package clg.bvu.ocms.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import clg.bvu.ocms.service.BranchService;
import clg.bvu.ocms.service.DocumentService;
import clg.bvu.ocms.service.PreferencesService;
import clg.bvu.ocms.service.UserService;

@Controller
@RequestMapping(value="/AdminController")
public class AdminController {
	
	private UserService userService;
	private DocumentService documentrService;
	private PreferencesService preferencesService;
	private BranchService branchService;
		
		@Autowired
		@Qualifier("UserServiceImpl")
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		
		@Autowired
		@Qualifier("DocumentServiceImpl")
		public void setDocumentService(DocumentService documentrService) {
			this.documentrService = documentrService;
		}
		
		@Autowired
		@Qualifier("PreferencesServiceImpl")
		public void setPreferencesService(PreferencesService preferencesService) {
			this.preferencesService = preferencesService;
		}
		
		@Autowired
		@Qualifier("BranchServiceImpl")
		public void setBranchService(BranchService branchService) {
			this.branchService = branchService;
		}
		
		@RequestMapping(value="/getBatchWiseUserDetails",method=RequestMethod.POST)
		@ResponseBody
		private  String getBatchWiseUserDetails(@RequestParam(value="batch",required=true) Integer batch
,
			HttpServletRequest request) {
		try {
			Integer userId=(Integer)request.getSession().getAttribute("user_id")+1;
			return userService.getBatchWiseUserDetails(batch);
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			try {
				
				json.put("msg", "Session Time Out Please Login");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return json.toString();
		}
	}
		
		@RequestMapping(value="/setUserTimeSlot",method=RequestMethod.POST)
		@ResponseBody
		private  String setUserTimeSlot(@RequestParam(value="startDAte",required=true) String startDAte
				,@RequestParam(value="endDate",required=true) String endDate
				,@RequestParam(value="userId",required=true) String userId
				,HttpServletRequest request){
			String userIds[]=userId.split(",");
			Integer user=(Integer)request.getSession().getAttribute("user_id")+1;
			return userService.setUserTimeSlot(startDAte,endDate,userIds);
		}
		
		@RequestMapping(value="/saveBranch",method=RequestMethod.POST)
		@ResponseBody
		private  String saveBranch(@RequestParam(value="branchName",required=true) String branchName
				,@RequestParam(value="availableSeats",required=true) Integer availableSeats
				,@RequestParam(value="totalSeats",required=true) Integer totalSeats
				,HttpServletRequest request){
			
			Integer userId=(Integer)request.getSession().getAttribute("user_id")+1;
			return branchService.saveBranch(branchName,availableSeats,totalSeats);
		}
		
		@RequestMapping(value="/deleteBranch",method=RequestMethod.POST)
		@ResponseBody
		private  String deleteBranch(@RequestParam(value="id",required=true) Integer id
				,HttpServletRequest request){
			Integer userId=(Integer)request.getSession().getAttribute("user_id")+1;
			return branchService.deleteBranch(id);
		}
		
		
		@RequestMapping(value="/updateDocumentStatus",method=RequestMethod.POST)
		@ResponseBody
		private  String updateDocumentStatus(@RequestParam(value="status",required=true) String status
				,@RequestParam(value="id",required=true) Integer id
				,HttpServletRequest request){
			Integer userId=(Integer)request.getSession().getAttribute("user_id")+1;
			return documentrService.updateDocumentStatus(id,status);
		}
		
		@RequestMapping(value="/result",method=RequestMethod.POST)
		@ResponseBody
		private  String result(@RequestParam(value="userId",required=true) String userId
				,HttpServletRequest request){
			String userIds[]=userId.split(",");
			Integer user=(Integer)request.getSession().getAttribute("user_id")+1;
			return userService.generateResult(userIds);
		}
		
		
		
}
