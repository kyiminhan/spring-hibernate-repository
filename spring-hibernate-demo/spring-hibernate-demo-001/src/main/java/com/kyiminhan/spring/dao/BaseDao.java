package com.kyiminhan.spring.dao;

import java.io.Serializable;
import java.util.Collection;

/**
 * The Interface BaseDao.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @param <KYIMINHAN> the generic type
 * @since 2019/03/15 </BR>
 *        spring-hibernate-demo-001 system </BR>
 *        com.kyiminhan.spring.dao </BR>
 *        BaseDao.java </BR>
 */
public interface BaseDao<KYIMINHAN extends Serializable> extends Serializable {

	/**
	 * Save.
	 *
	 * @param kyiminhan the kyiminhan
	 */
	void save(KYIMINHAN kyiminhan);

	/**
	 * Update.
	 *
	 * @param kyiminhan the kyiminhan
	 */
	void update(KYIMINHAN kyiminhan);

	/**
	 * Delete.
	 *
	 * @param kyiminhan the kyiminhan
	 */
	void delete(KYIMINHAN kyiminhan);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return KYIMINHAN
	 */
	KYIMINHAN findById(Integer id);

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	Collection<KYIMINHAN> getAll();
}