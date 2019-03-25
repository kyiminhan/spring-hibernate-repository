package com.kyiminhan.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.kyiminhan.spring.dao.DepartmentDao;
import com.kyiminhan.spring.entity.Department;

/**
 * The Class DepartmentDaoImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/03/15 </BR>
 *        spring-hibernate-demo-001 system </BR>
 *        com.kyiminhan.spring.dao.impl </BR>
 *        DepartmentDaoImpl.java </BR>
 */
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Override
	public void initialInsert() {
		int count = 1;
		for (int i = 1; i <= 2000; i++) {
			this.getSession().persist(Department.builder()
					.departmentName(new StringBuilder("IT Department ").append(String.valueOf(i)).toString()).build());
			System.out.println(count);
			count++;
		}
		System.out.println("Commit : " + count);

	}

}