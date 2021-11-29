package com.swoqe.adsformads.rest;

import com.swoqe.adsformads.model.dto.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "data", path = "prices")
public interface PriceRestResource extends JpaRepository<Price, UUID> {

}
