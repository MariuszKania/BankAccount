package pl.sda.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.sda.model.Deposit;
@Repository
public class DepositDao extends AbstractDao<Deposit> {

	protected DepositDao(Deposit t) {
		super(t);
		
	}
	public List<Deposit> getDepositsByAccountId(Long accountId){
		DetachedCriteria criteria = getDetachedCriteria();
		criteria.add(Restrictions.eq("clientAccount.id", accountId));
		return getHibernateTemplate().findByCriteria(criteria);
	}

}
