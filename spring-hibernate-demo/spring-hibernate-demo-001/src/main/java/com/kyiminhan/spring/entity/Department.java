package com.kyiminhan.spring.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Department.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 16, 2019 </BR>
 *        spring-hibernate-demo-001 system </BR>
 *        com.kyiminhan.spring.entity </BR>
 *        Department.java </BR>
 */
@Getter

/**
 * Sets the department name.
 *
 * @param departmentName the new department name
 */
@Setter

/*
 * (non-Javadoc)
 *
 * @see java.lang.Object#toString()
 */

/**
 * Builds the.
 *
 * @return Department
 */
@Builder

/**
 * Instantiates a new department.
 */

/**
 * Instantiates a new department.
 */
@NoArgsConstructor

/**
 * Instantiates a new department.
 *
 * @param id             the id
 * @param departmentName the department name
 */
@AllArgsConstructor
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Department implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	/** The department name. */
	@Column
	private String departmentName;
}
