package com.kyiminhan.spring.dao;

import com.kyiminhan.spring.entity.Department;

/**
 * The Interface DepartmentDao.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/03/15 </BR>
 *        spring-hibernate-demo-001 system </BR>
 *        com.kyiminhan.spring.dao </BR>
 *        DepartmentDao.java </BR>
 */
public interface DepartmentDao extends BaseDao<Department> {
	void initialInsert();
}