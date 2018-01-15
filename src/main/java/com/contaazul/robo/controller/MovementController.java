package com.contaazul.robo.controller;

import com.contaazul.robo.model.Coordinate;
import com.contaazul.robo.model.Robot;
import com.contaazul.robo.service.MovementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/mars/{command}",method = RequestMethod.POST)
    public ResponseEntity<String> move(@PathVariable String command){
        LOGGER.info("Start request in endpoint /mars/{}", command);
        final Robot robotState = movementService.moveRobot(command, new Robot(0, 0, Coordinate.N));
        return new ResponseEntity<String>(robotState.toString(), HttpStatus.OK);
    }

}
