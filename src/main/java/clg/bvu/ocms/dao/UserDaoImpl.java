package clg.bvu.ocms.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	
	

}
