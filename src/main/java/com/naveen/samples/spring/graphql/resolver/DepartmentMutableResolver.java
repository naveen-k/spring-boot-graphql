package com.naveen.samples.spring.graphql.resolver;

import com.naveen.samples.spring.graphql.entity.Department;
import com.naveen.samples.spring.graphql.model.DepartmentInput;
import com.naveen.samples.spring.graphql.entity.Organization;
import graphql.kickstart.tools.GraphQLMutationResolver;
import com.naveen.samples.spring.graphql.repository.DepartmentRepository;
import com.naveen.samples.spring.graphql.repository.OrganizationRepository;

import org.springframework.stereotype.Component;

@Component
public class DepartmentMutableResolver implements GraphQLMutationResolver {

	DepartmentRepository departmentRepository;
	OrganizationRepository organizationRepository;

	DepartmentMutableResolver(DepartmentRepository departmentRepository, OrganizationRepository organizationRepository) {
		this.departmentRepository = departmentRepository;
		this.organizationRepository = organizationRepository;
	}

	public Department newDepartment(DepartmentInput departmentInput) {
		Organization organization = organizationRepository.findById(departmentInput.getOrganizationId()).get();
		return departmentRepository.save(new Department(null, departmentInput.getName(), null, organization));
	}

}
