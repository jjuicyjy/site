package com.site.controller;

import com.site.entity.User;
import com.site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public User signUp(@RequestBody User user){
        if (user.getName().isEmpty() || user.getLastname().isEmpty() ||
                user.getNumberPhone().isEmpty() || user.getPassword().isEmpty()){
            return null;
        }
        return userService.signUp(user);
    }

    @PostMapping("/signIn")
    public User signIn(@RequestBody User user){
        if (user.getNumberPhone().isEmpty() || user.getPassword().isEmpty()){
            return null;
        }
        return userService.signIn(user);
    }
}
