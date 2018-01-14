package com.contaazul.robo.service;

import com.contaazul.robo.RoboApplicationTests;
import com.contaazul.robo.exception.InvalidCommandException;
import com.contaazul.robo.exception.InvalidPositionException;
import com.contaazul.robo.model.Coordinate;
import com.contaazul.robo.model.Robot;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class MovementServiceTest extends RoboApplicationTests{

    @Autowired
    private MovementService movementService;

    @Test(expected = InvalidCommandException.class)
    public void moveRobotNull(){
        movementService.moveRobot("M", null);
    }

    @Test
    public void moveRobot2SteepNorth(){
        final Robot robot = new Robot(0, 0, Coordinate.N);
        final Robot robotReturn = movementService.moveRobot("MM", robot);
        assertTrue(robotReturn.getY() == 2);
    }

    @Test(expected = InvalidPositionException.class)
    public void moveRobot5SteepNorth(){
        final Robot robot = new Robot(0, 0, Coordinate.N);
        final Robot robotReturn = movementService.moveRobot("MMMMM", robot);
    }



}
