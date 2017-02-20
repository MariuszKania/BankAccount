package pl.sda.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.sda.model.User;

@Repository
public class UserDao extends AbstractDao<User> {

	public UserDao(User t) {
		super(t);
		
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {
		DetachedCriteria criteria = getDetachedCriteria();
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		List<User> list = getHibernateTemplate().findByCriteria(criteria);
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
}

