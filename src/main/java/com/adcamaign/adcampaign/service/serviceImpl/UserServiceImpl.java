package com.adcamaign.adcampaign.service.serviceImpl;

import com.adcamaign.adcampaign.business.User;
import com.adcamaign.adcampaign.dao.UserRepository;
import com.adcamaign.adcampaign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String email, String password) {
        return userRepository.findFirstByEmailAndPassword(email, password);

    }
}
