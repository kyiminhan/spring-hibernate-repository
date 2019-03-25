package com.kyiminhan.spring.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyiminhan.spring.dao.DepartmentDao;
import com.kyiminhan.spring.entity.Department;
import com.kyiminhan.spring.service.DepartmentService;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class DepartmentServiceImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/03/15 </BR>
 *        spring-hibernate-demo-001 system </BR>
 *        com.kyiminhan.spring.service.impl </BR>
 *        DepartmentServiceImpl.java </BR>
 */
@Service
@NoArgsConstructor
@Setter(onMethod = @__(@Autowired))
public class DepartmentServiceImpl implements DepartmentService {

	/** The department dao. */
	private DepartmentDao departmentDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.DepartmentService#save(com.kyiminhan.spring.
	 * entity .Department)
	 */
	@Override
	@Transactional
	public void save(final Department department) {
		this.departmentDao.save(department);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.DepartmentService#update(com.kyiminhan.spring.
	 * entity.Department)
	 */
	@Override
	@Transactional
	public void update(final Department department) {
		this.departmentDao.update(department);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.DepartmentService#delete(com.kyiminhan.spring.
	 * entity.Department)
	 */
	@Override
	@Transactional
	public void delete(final Department department) {
		this.departmentDao.delete(department);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.DepartmentService#findById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Department findById(final Integer id) {
		// TODO Auto-generated method stub
		return this.departmentDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.service.DepartmentService#getAll()
	 */
	@Override
	@Transactional
	public Collection<Department> getAll() {
		return this.departmentDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.service.DepartmentService#initialInsert()
	 */
	@Override
	@Transactional
	public void initialInsert() {
		this.departmentDao.initialInsert();
	}
}