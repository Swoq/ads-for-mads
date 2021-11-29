package com.swoqe.adsformads.rest;

import com.swoqe.adsformads.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "data", path = "orders")
public interface OrderRestResource extends JpaRepository<Order, UUID> {

}
