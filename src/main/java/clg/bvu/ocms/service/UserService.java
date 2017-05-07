package clg.bvu.ocms.service;


public interface UserService {

	String getUserData(Integer userId);

	String getBatchWiseUserDetails(Integer batch);

	String setUserTimeSlot(String startDAte, String endDate, String[] userIds);



}
