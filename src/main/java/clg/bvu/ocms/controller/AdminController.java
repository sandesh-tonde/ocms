package clg.bvu.ocms.controller;

import javax.servlet.http.HttpServletRequest;

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
				,HttpServletRequest request){
			return userService.getBatchWiseUserDetails(batch);
		}
		
		@RequestMapping(value="/setUserTimeSlot",method=RequestMethod.POST)
		@ResponseBody
		private  String setUserTimeSlot(@RequestParam(value="startDAte",required=true) String startDAte
				,@RequestParam(value="endDate",required=true) String endDate
				,@RequestParam(value="userId",required=true) String userId
				,HttpServletRequest request){
			String userIds[]=userId.split(",");
			return userService.setUserTimeSlot(startDAte,endDate,userIds);
		}
		
		

}
