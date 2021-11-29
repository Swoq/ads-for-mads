package com.swoqe.adsformads.rest;

import com.swoqe.adsformads.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRestResource extends JpaRepository<Customer, UUID> {

}
