package com.contaazul.robo.controller;

import com.contaazul.robo.service.MovementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovementController {

    public static final Logger LOGGER = LoggerFactory.getLogger(MovementController.class);

    private MovementService movementService;

    @Autowired
    public MovementController(MovementService movementService){
        this.movementService = movementService;
    }

    @RequestMapping(value = "/mars/{command}",method = RequestMethod.PUT)
    public void move(@PathVariable String command){
        LOGGER.info("Start request in endpoint /mars/{}", command);
        movementService.toMove(command);
    }

}
