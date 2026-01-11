package com.example.userservice.service;

import com.example.userservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User createUser(User user);

    public User getUser(long id);

    public User blockUser(long id);

}
