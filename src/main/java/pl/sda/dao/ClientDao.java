package pl.sda.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.sda.model.Client;
import pl.sda.model.User;

@Repository
public class ClientDao extends AbstractDao<Client> {

	public ClientDao(Client t) {
		super(t);
	}
	
	public Client getByUsername(String username) {
		DetachedCriteria criteria = getDetachedCriteria();
		criteria.add(Restrictions.eq("name", username));
		List<Client> list = getHibernateTemplate().findByCriteria(criteria);
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
}
