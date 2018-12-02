package com.poc.springbootpoc.controller;

import com.poc.springbootpoc.bean.UserForm;
import com.poc.springbootpoc.entity.UserProfile;
import com.poc.springbootpoc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorld {

    Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUser(){

        logger.info("in method starting");
        return "Welcome";
    }

    @PostMapping("/registration")
    public String saveUser(@RequestBody() UserForm userForm){

        String status;

        UserProfile userP = new UserProfile();
        BeanUtils.copyProperties(userForm, userP);

        if(getUser(userP.getUserName())!=null){
            status = "User Already Exist";
        }else{
            userService.save(userP);
            status = "User Created Successfully";
        }

        return  status;

    }

    @GetMapping("/getuser")
    public UserProfile getUser(@RequestParam() String userName) {

        UserProfile userProfile = userService.getUser(userName);

        return userProfile;

    }

}
