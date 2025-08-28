package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String registerUser(User user){
        User usernameExisting=userRepository.findByUsername(user.getUsername());
        if(usernameExisting!=null){
            return "Username Already Exists";
        }

        user.setPassword(user.getPassword());
        user.setUsername(user.getUsername());
        return "Username registered Successfully";
    }
}
