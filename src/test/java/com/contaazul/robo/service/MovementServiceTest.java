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
        final Robot robotNorthReturn = movementService.moveRobot("MM", getRobotDirectionN());
        assertTrue(robotNorthReturn.getY() == 2);

        final Robot robotSouthReturn = movementService.moveRobot("M", new Robot(0, 1, Coordinate.S));
        assertTrue(robotSouthReturn.getY() == 0);

        final Robot robotWestReturn = movementService.moveRobot("M", new Robot(0, 0, Coordinate.W));
        assertTrue(robotWestReturn.getX() == 1);

        final Robot robotEastReturn = movementService.moveRobot("M", new Robot(1, 0, Coordinate.E));
        assertTrue(robotEastReturn.getX() == 0);
    }

    @Test(expected = InvalidPositionException.class)
    public void moveRobot5SteepNorth(){
        final Robot robotReturn = movementService.moveRobot("MMMMM", getRobotDirectionN());
    }

    @Test(expected = InvalidPositionException.class)
    public void moveRobot1SteepSouth(){
        final Robot robotReturn = movementService.moveRobot("M", new Robot(0, 0, Coordinate.S));
    }

    @Test
    public void rotateRobot1SteepLeft(){
        final Robot robotReturn = movementService.moveRobot("L", getRobotDirectionN());
        assertTrue(robotReturn.getX() == 0);
        assertTrue(robotReturn.getY() == 0);
        assertEquals(robotReturn.getDirection(), Coordinate.W);
    }

    @Test
    public void rotateRobot1SteepRight(){
        final Robot robotReturn = movementService.moveRobot("R", getRobotDirectionN());
        assertTrue(robotReturn.getX() == 0);
        assertTrue(robotReturn.getY() == 0);
        assertEquals(robotReturn.getDirection(), Coordinate.E);
    }


    @Test
    public void validMultipleMovementRobot(){
        final Robot robotReturn = movementService.moveRobot("MMLM", getRobotDirectionN());
        assertTrue(robotReturn.getX() == 1);
        assertTrue(robotReturn.getY() == 2);
        assertEquals(robotReturn.getDirection(), Coordinate.W);
    }

    @Test
    public void rotate180Robot(){
        final Robot robotReturn = movementService.moveRobot("LL", getRobotDirectionN());
        assertTrue(robotReturn.getX() == 0);
        assertTrue(robotReturn.getY() == 0);
        assertEquals(robotReturn.getDirection(), Coordinate.S);
    }

    @Test
    public void rotate360Robot(){
        final Robot robotReturn = movementService.moveRobot("RRRR", getRobotDirectionN());
        assertTrue(robotReturn.getX() == 0);
        assertTrue(robotReturn.getY() == 0);
        assertEquals(robotReturn.getDirection(), Coordinate.N);
    }

    @Test(expected = InvalidPositionException.class)
    public void movementRobotOutN(){
        final Robot robotReturn = movementService.moveRobot("MMMMMM", getRobotDirectionN());
    }

    @Test(expected = InvalidPositionException.class)
    public void movementRobotOutE(){
        final Robot robotReturn = movementService.moveRobot("MMRM", getRobotDirectionN());
    }

    @Test(expected = InvalidPositionException.class)
    public void movementRobotOutW(){
        final Robot robotReturn = movementService.moveRobot("MLMMMMM", getRobotDirectionN());
    }


    @Test(expected = InvalidPositionException.class)
    public void movementRobotOutS(){
        final Robot robotReturn = movementService.moveRobot("LLM", getRobotDirectionN());
    }

    private Robot getRobotDirectionN() {
        return new Robot(0, 0, Coordinate.N);
    }



}
