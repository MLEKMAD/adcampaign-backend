package com.adcamaign.adcampaign.dao;

import com.adcamaign.adcampaign.business.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmailAndPassword(String email, String password);
}
