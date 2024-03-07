package com.dharmycode.user.service;

import com.dharmycode.user.entities.Users;
import com.dharmycode.user.repository.UserRepository;
import com.dharmycode.user.valueobject.Department;
import com.dharmycode.user.valueobject.ResponseTemplateValueObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public Users saveUser(Users users) {
        log.info("Inside saveUser of UserController");
        return userRepository.save(users);
    }

    public ResponseTemplateValueObject getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        ResponseTemplateValueObject responseTemplateValueObject = new ResponseTemplateValueObject();
        Users users = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/v1/departments/department/" + users.getDepartmentId(),
                        Department.class );

        responseTemplateValueObject.setUsers(users);
        responseTemplateValueObject.setDepartment(department);

        return responseTemplateValueObject;
    }
}
