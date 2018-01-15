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
    public void moveRobotSteep(){
        final Robot robotNorth = new Robot(0, 0, Coordinate.N);
        final Robot robotNorthReturn = movementService.moveRobot("MM", robotNorth);
        assertTrue(robotNorthReturn.getY() == 2);

        final Robot robotSouth = new Robot(0, 1, Coordinate.S);
        final Robot robotSouthReturn = movementService.moveRobot("M", robotSouth);
        assertTrue(robotSouthReturn.getY() == 0);

        final Robot robotWest = new Robot(0, 0, Coordinate.W);
        final Robot robotWestReturn = movementService.moveRobot("M", robotWest);
        assertTrue(robotWestReturn.getX() == 1);

        final Robot robotEast = new Robot(1, 0, Coordinate.E);
        final Robot robotEastReturn = movementService.moveRobot("M", robotEast);
        assertTrue(robotEastReturn.getX() == 0);
    }

    @Test(expected = InvalidPositionException.class)
    public void moveRobot5SteepNorth(){
        final Robot robot = new Robot(0, 0, Coordinate.N);
        final Robot robotReturn = movementService.moveRobot("MMMMM", robot);
    }

    @Test(expected = InvalidPositionException.class)
    public void moveRobot1SteepSouth(){
        final Robot robot = new Robot(0, 0, Coordinate.S);
        final Robot robotReturn = movementService.moveRobot("M", robot);
    }

    @Test
    public void rotateRobot1SteepLeft(){
        final Robot robot = new Robot(0, 0, Coordinate.N);
        final Robot robotReturn = movementService.moveRobot("L", robot);
        assertTrue(robotReturn.getX() == 0);
        assertTrue(robotReturn.getY() == 0);
        assertEquals(robotReturn.getDirection(), Coordinate.W);
    }

    @Test
    public void rotateRobot1SteepRight(){
        final Robot robot = new Robot(0, 0, Coordinate.N);
        final Robot robotReturn = movementService.moveRobot("R", robot);
        assertTrue(robotReturn.getX() == 0);
        assertTrue(robotReturn.getY() == 0);
        assertEquals(robotReturn.getDirection(), Coordinate.E);
    }



}
