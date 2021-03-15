package com.naveen.samples.spring.graphql.repository;

import com.naveen.samples.spring.graphql.entity.Department;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer>,
		JpaSpecificationExecutor<Department> {

}
