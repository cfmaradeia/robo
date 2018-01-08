package com.contaazul.robo.service;

import com.contaazul.robo.RoboApplicationTests;
import com.contaazul.robo.exception.InvalidCommandException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MovementServiceTest extends RoboApplicationTests{

    @Autowired
    private MovementService movementService;


    @Test(expected = InvalidCommandException.class)
    public void toMoveCommandEmptyTest(){
        movementService.toMove("");
    }

    @Test(expected = InvalidCommandException.class)
    public void toMoveCommandNullTest(){
        movementService.toMove(null);
    }

    @Test(expected = InvalidCommandException.class)
    public void toMoveCommandInvalidTest(){
        movementService.toMove("C");
    }
}
