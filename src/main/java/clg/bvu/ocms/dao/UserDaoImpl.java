package clg.bvu.ocms.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import clg.bvu.ocms.model.User;



@Repository(value="UserDaoImpl")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HttpSession httpSession;
	
	private Logger log = Logger.getLogger(LoginDaoImpl.class.getClass());
	
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUserData(Integer userId) {
		
		Session session =sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq("userId", userId));
				
		User u=(User) criteria.uniqueResult();
		return u;
		//return null;
	}

	@Override
	public List<User> getBatchWiseUserDetails(Integer batch) {
		Session session =sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class, "user")
				.add(Restrictions.eq("user.userType" ,"student"))
				.setFirstResult((batch-1)*60)
				.setMaxResults(60);
		List<User> users= criteria.list();
		return users;
		//return null;
	}

	@Override
	public void setUserTimeSlot(Date sDate, Date eDate, List<Integer> userId) {
		Session session =sessionFactory.getCurrentSession();
		for(Integer id :userId){
			User u=(User) session.load(User.class, id);
			u.setCouncellingDate(sDate);
			u.setStartTime(sDate);
			u.setEndTime(eDate);
			session.update(u);
		}
		
	}

	@Override
	public List<User> getUsers(List<Integer> userId) {
		Session session =sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class, "user")
				.add(Restrictions.in("user.user_id" ,userId))
				.addOrder(Order.asc("user.rank"));
		List<User> users= criteria.list();
		return users;
	}
	
	

}
