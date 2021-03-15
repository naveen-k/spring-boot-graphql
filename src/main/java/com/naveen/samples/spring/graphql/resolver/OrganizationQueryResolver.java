package com.naveen.samples.spring.graphql.resolver;

import com.naveen.samples.spring.graphql.entity.Organization;
import graphql.kickstart.tools.GraphQLQueryResolver;
import com.naveen.samples.spring.graphql.repository.OrganizationRepository;

import org.springframework.stereotype.Component;

@Component
public class OrganizationQueryResolver implements GraphQLQueryResolver {

	private OrganizationRepository repository;

	OrganizationQueryResolver(OrganizationRepository repository) {
		this.repository = repository;
	}

	public Iterable<Organization> organizations() {
		return repository.findAll();
	}

	public Organization organization(Integer id) {
		return repository.findById(id).get();
	}
}
