package clg.bvu.ocms.dao;

import java.util.Date;
import java.util.List;

import clg.bvu.ocms.model.User;



public interface UserDao {

	User getUserData(Integer userId);

	List<User> getBatchWiseUserDetails(Integer batch);

	void setUserTimeSlot(Date sDate, Date eDate, List<Integer> userId);

	List<User> getUsers(List<Integer> userId);

	void updateUser(User user);



}
