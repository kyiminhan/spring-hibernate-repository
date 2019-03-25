package com.kyiminhan.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.kyiminhan.spring.dao.EmployeeDao;
import com.kyiminhan.spring.entity.Employee;

/**
 * The Class EmployeeDaoImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/03/15 </BR>
 *        spring-hibernate-demo-001 system </BR>
 *        com.kyiminhan.spring.dao.impl </BR>
 *        EmployeeDaoImpl.java </BR>
 */
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

}