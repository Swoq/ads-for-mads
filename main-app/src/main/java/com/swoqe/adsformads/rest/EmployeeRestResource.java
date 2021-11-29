package com.swoqe.adsformads.rest;

import com.swoqe.adsformads.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRestResource extends JpaRepository<Employee, UUID> {

}
