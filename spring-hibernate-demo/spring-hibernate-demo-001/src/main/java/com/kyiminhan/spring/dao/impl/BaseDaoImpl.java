
package com.kyiminhan.spring.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyiminhan.spring.dao.BaseDao;

import lombok.Setter;

/**
 * The Class BaseDaoImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @param <KYIMINHAN> the generic type
 * @since 2019/03/15 </BR>
 *        spring-hibernate-demo-001 system </BR>
 *        com.kyiminhan.spring.dao.impl </BR>
 *        BaseDaoImpl.java </BR>
 */

@Repository
public abstract class BaseDaoImpl<KYIMINHAN extends Serializable> implements BaseDao<KYIMINHAN> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clazz. */
	protected Class<KYIMINHAN> clazz;

	/** The session factory. */
	@Setter(onMethod = @__(@Autowired))
	private SessionFactory sessionFactory;

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	protected Session getSession() {
		final Session session = this.sessionFactory.getCurrentSession();
		return (null != session) ? session : this.sessionFactory.openSession();
	}

	/**
	 * Instantiates a new base dao impl.
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.clazz = (Class<KYIMINHAN>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.dao.BaseDao#save(java.io.Serializable)
	 */
	@Override
	public void save(final KYIMINHAN kyiminhan) {
		this.getSession().persist(kyiminhan);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.dao.BaseDao#update(java.io.Serializable)
	 */
	@Override
	public void update(final KYIMINHAN kyiminhan) {
		this.getSession().merge(kyiminhan);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.dao.BaseDao#delete(java.io.Serializable)
	 */
	@Override
	public void delete(final KYIMINHAN kyiminhan) {
		this.getSession().remove(kyiminhan);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.dao.BaseDao#findById(java.lang.Integer)
	 */
	@Override
	public KYIMINHAN findById(final Integer id) {
		final CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		final CriteriaQuery<KYIMINHAN> criteriaQuery = criteriaBuilder.createQuery(this.clazz);
		final Root<KYIMINHAN> root = criteriaQuery.from(this.clazz);
		criteriaQuery.select(root);
		final List<Predicate> predicates = new ArrayList<>();
		predicates.add(criteriaBuilder.equal(root.get("id"), id));
		criteriaQuery.where(predicates.toArray(new Predicate[0])).distinct(true);
		return this.getSession().createQuery(criteriaQuery).setHint(QueryHints.HINT_FETCH_SIZE, 50).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.dao.BaseDao#getAll()
	 */
	@Override
	public Collection<KYIMINHAN> getAll() {
		final CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		final CriteriaQuery<KYIMINHAN> criteriaQuery = criteriaBuilder.createQuery(this.clazz);
		final Root<KYIMINHAN> root = criteriaQuery.from(this.clazz);
		criteriaQuery.select(root);
		final List<Predicate> predicates = new ArrayList<>();
		criteriaQuery.where(predicates.toArray(new Predicate[0])).distinct(true);
		return this.getSession().createQuery(criteriaQuery).setHint(QueryHints.HINT_FETCH_SIZE, 50).getResultList();
	}
}