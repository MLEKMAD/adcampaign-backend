package com.adcamaign.adcampaign.service;

import com.adcamaign.adcampaign.business.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getUsers();
    User getUser(String email, String password);
}
