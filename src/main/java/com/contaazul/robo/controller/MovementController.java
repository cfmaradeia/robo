package com.contaazul.robo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovementController {

    public static final Logger LOGGER = LoggerFactory.getLogger(MovementController.class);

    @RequestMapping(value = "/mars",method = RequestMethod.PUT)
    public void move(){
        LOGGER.info("Start");
    }

}
