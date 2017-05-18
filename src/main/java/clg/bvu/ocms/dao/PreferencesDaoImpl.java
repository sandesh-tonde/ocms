package clg.bvu.ocms.dao;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import clg.bvu.ocms.model.Branch;
import clg.bvu.ocms.model.Preference;
import clg.bvu.ocms.model.User;

@Repository(value="PreferencesDaoImpl")
public class PreferencesDaoImpl implements PreferencesDao {
	
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
	public Preference getPreferences(Integer userId) {
		Session session =sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Preference.class, "Preference")
				.createAlias("Preference.user", "User")
				.add(Restrictions.eq("User.userId", userId));
				
				
		Preference pref=(Preference) criteria.uniqueResult();
		return pref;
	}

	@Override
	public int savePreferences(Integer option1, Integer option2,
			Integer option3, Integer userId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Branch op1 = (Branch) session.load(Branch.class, option1);
			Branch op2 = (Branch) session.load(Branch.class, option2);
			Branch op3 = (Branch) session.load(Branch.class, option3);
			User u = (User) session.load(User.class, userId);
			
			Preference pref = new Preference();
			pref.setUser(u);
			pref.setOption1(op1);
			pref.setOption2(op2);
			pref.setOption3(op3);
			session.save(pref);
			u.setPreference(pref);
			session.update(u);
			return 1;
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		return 0;
	}

}
