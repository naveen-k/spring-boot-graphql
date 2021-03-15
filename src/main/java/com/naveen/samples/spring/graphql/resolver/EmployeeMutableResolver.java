package com.naveen.samples.spring.graphql.resolver;

import com.naveen.samples.spring.graphql.entity.Department;
import com.naveen.samples.spring.graphql.entity.Employee;
import com.naveen.samples.spring.graphql.model.EmployeeInput;
import com.naveen.samples.spring.graphql.entity.Organization;
import graphql.kickstart.tools.GraphQLMutationResolver;
import com.naveen.samples.spring.graphql.repository.DepartmentRepository;
import com.naveen.samples.spring.graphql.repository.EmployeeRepository;
import com.naveen.samples.spring.graphql.repository.OrganizationRepository;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMutableResolver implements GraphQLMutationResolver {

	DepartmentRepository departmentRepository;
	EmployeeRepository employeeRepository;
	OrganizationRepository organizationRepository;

	EmployeeMutableResolver(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, OrganizationRepository organizationRepository) {
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
		this.organizationRepository = organizationRepository;
	}

	public Employee newEmployee(EmployeeInput employeeInput) {
		Department department = departmentRepository.findById(employeeInput.getDepartmentId()).get();
		Organization organization = organizationRepository.findById(employeeInput.getOrganizationId()).get();
		return employeeRepository.save(new Employee(null, employeeInput.getFirstName(), employeeInput.getLastName(),
				employeeInput.getPosition(), employeeInput.getAge(), employeeInput.getSalary(),
				department, organization));
	}

}
