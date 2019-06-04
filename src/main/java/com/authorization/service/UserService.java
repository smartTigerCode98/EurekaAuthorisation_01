package com.authorization.service;


import com.authorization.repository.UserRepository;
import com.authorization.entities.User;
import com.authorization.security.JwtConfig;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String authenticate(User user) {
        Optional<User> userAuth = userRepository.findByEmail(user.getEmail());
        if(!userAuth.get().getPassword().equals(user.getPassword())) {
            return null;
        }
        return JwtConfig.buildJWT(new Gson().toJson(userAuth));
    }

}
