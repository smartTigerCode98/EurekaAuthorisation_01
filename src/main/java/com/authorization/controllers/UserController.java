package com.authorization.controllers;
import com.authorization.service.UserService;
import com.authorization.entities.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUser(@RequestBody String body) {
        User user = new Gson().fromJson(body, User.class);
        return userService.authenticate(user);
    }
}