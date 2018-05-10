package com.codevik.socialmediaapiintegration.controller;


import com.codevik.socialmediaapiintegration.model.User;
import com.codevik.socialmediaapiintegration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    Flux<User> findAll(){
        return userService.findAll();
    }
}
