package com.swoqe.adsformads.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomAuthorityRepository extends JpaRepository<CustomAuthority, String> {
}
