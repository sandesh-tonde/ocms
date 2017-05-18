package clg.bvu.ocms.service;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import clg.bvu.ocms.dao.PreferencesDao;
import clg.bvu.ocms.dao.UserDao;
import clg.bvu.ocms.model.Preference;
import clg.bvu.ocms.model.User;



@Service("PreferencesServiceImpl")
public class PreferencesServiceImpl implements PreferencesService {
	
	private PreferencesDao preferencesDao;
	private UserDao userDao;

	@Autowired
	@Qualifier("PreferencesDaoImpl")
	public void setPreferenceDetailsDao(PreferencesDao preferencesDao) {
		this.preferencesDao = preferencesDao;
	}
	
	@Autowired
	@Qualifier("UserDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String getPreferences(Integer userId) {
		Preference pref=preferencesDao.getPreferences(userId);
		JSONArray jsonArray =new JSONArray();
		JSONObject json1= new JSONObject();
		JSONObject json2= new JSONObject();
		JSONObject json3= new JSONObject();
		if (pref != null) {
			try {
				json1.put("branchId", pref.getOption1().getBranchId());
				json1.put("branchName", pref.getOption1().getBranchName());
				json1.put("option", "Option1");

				json2.put("branchId", pref.getOption2().getBranchId());
				json2.put("branchName", pref.getOption2().getBranchName());
				json2.put("option", "Option2");

				json3.put("branchId", pref.getOption3().getBranchId());
				json3.put("branchName", pref.getOption3().getBranchName());
				json3.put("option", "Option3");

				jsonArray.put(json1);
				jsonArray.put(json2);
				jsonArray.put(json3);

				return jsonArray.toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else{
			User u=userDao.getUserData(userId);
			Date serverDate = new Date();
			System.out.println(serverDate);
			System.out.println(serverDate.after(u.getStartTime())+"-"+u.getStartTime());
			System.out.println(serverDate.before(u.getEndTime())+"-"+u.getEndTime());
			//System.out.println(!serverDate.after(u.getStartTime()) && !serverDate.before(u.getEndTime()));
			if(serverDate.after(u.getStartTime())) { //&& serverDate.before(u.getEndTime())){
				if(serverDate.before(u.getEndTime())){
				
				} else {
					try {
						json1.put("msg", "Preferences Available in Given time slot Only");
						return json1.toString();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			} else {
				try {
					json1.put("msg", "Preferences Available in Given time slot Only");
					return json1.toString();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return jsonArray.toString();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String savePreferences(Integer option1, Integer option2,
			Integer option3, Integer userId) {
			int i=preferencesDao.savePreferences(option1, option2,option3, userId);
			JSONObject json= new JSONObject();
			try {
				if(i==1)
					json.put("msg", "Preferences Saved Successfully");
				else
					json.put("msg", "Preferences Saving Failed");
				return json.toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	
	

}
