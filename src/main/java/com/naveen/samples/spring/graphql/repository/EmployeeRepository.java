package com.naveen.samples.spring.graphql.repository;

import com.naveen.samples.spring.graphql.entity.Employee;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>,
		JpaSpecificationExecutor<Employee> {
}
