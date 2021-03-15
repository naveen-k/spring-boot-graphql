package com.naveen.samples.spring.graphql.repository;

import com.naveen.samples.spring.graphql.entity.Organization;

import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
}
