package pl.sda.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public class AbstractDao<T>  extends HibernateDaoSupport {
	
	private T t;
	
	protected AbstractDao(T t) {
		this.t = t;
	}
	
	public List<T> getAll() {
		DetachedCriteria criteria = getDetachedCriteria();
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	public void save(T obj) {
		getHibernateTemplate().save(obj);
	}
	
	public void update(T obj) {
		getHibernateTemplate().update(obj);
	}
	
	public void delete(Long id) {
		getHibernateTemplate().delete(getById(id));
	}
	
	public T getById(Long id) {
		DetachedCriteria criteria = getDetachedCriteria();
		criteria.add(Restrictions.eq("id", id));
		List<T> list = getHibernateTemplate().findByCriteria(criteria);
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	protected DetachedCriteria getDetachedCriteria() {
		return DetachedCriteria.forClass(t.getClass());
	}
}
