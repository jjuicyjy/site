package com.site.service;

import com.site.entity.User;
import com.site.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User signUp(User user) {
        if (userRepo.existsUserByNumberPhone(user.getNumberPhone())) {
            return null;
        }
        return userRepo.save(user);
    }

    public User signIn(User user) {
        User userBD = userRepo.findByNumberPhone(user.getNumberPhone());
        if (userBD != null && userBD.getPassword().equals(user.getPassword())) {
            return userBD;
        }
        return null;
    }
}
