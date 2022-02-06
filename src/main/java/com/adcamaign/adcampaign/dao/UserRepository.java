package com.adcamaign.adcampaign.dao;

import com.adcamaign.adcampaign.business.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
