package pl.sda.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.sda.model.ClientAccount;
@Repository
public class ClientAccountDao extends AbstractDao<ClientAccount> {

	public ClientAccountDao(ClientAccount t) {
		super(t);
		
	}
	public List<ClientAccount> getAccountsByClientId(Long clientId){
		DetachedCriteria criteria = getDetachedCriteria();
		criteria.add(Restrictions.eq("client.id", clientId));
		return getHibernateTemplate().findByCriteria(criteria);
		
	}
	
}
