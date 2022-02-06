package com.adcamaign.adcampaign.dao;

import java.util.Optional;

import com.adcamaign.adcampaign.business.ERole;
import com.adcamaign.adcampaign.business.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
