package com.naveen.samples.spring.graphql.resolver;

import com.naveen.samples.spring.graphql.entity.Organization;
import com.naveen.samples.spring.graphql.model.OrganizationInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import com.naveen.samples.spring.graphql.repository.OrganizationRepository;

import org.springframework.stereotype.Component;

@Component
public class OrganizationMutableResolver implements GraphQLMutationResolver {

	OrganizationRepository repository;

	OrganizationMutableResolver(OrganizationRepository repository) {
		this.repository = repository;
	}

	public Organization newOrganization(OrganizationInput organizationInput) {
		return repository.save(new Organization(null, organizationInput.getName(), null, null));
	}

}
