package com.poc.springbootpoc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @GetMapping("/")
    public String getUser(){

        logger.info("in method starting");
        return "Welcome";
    }

}
