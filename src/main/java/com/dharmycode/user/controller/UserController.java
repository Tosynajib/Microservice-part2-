package com.dharmycode.user.controller;

import com.dharmycode.user.entities.Users;
import com.dharmycode.user.service.UserService;
import com.dharmycode.user.valueobject.ResponseTemplateValueObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    private UserService userService;
    private RestTemplate restTemplate;

    @Autowired
    public UserController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/")
    public Users saveUser(@RequestBody Users users) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(users);
    }

    @GetMapping("/{id}")
    public ResponseTemplateValueObject getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }


}
