package com.contaazul.robo.Model;

import com.contaazul.robo.RoboApplicationTests;
import com.contaazul.robo.model.Coordinate;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest extends RoboApplicationTests{

    @Test
    public void nextPositonTest(){
        Coordinate startPosition = Coordinate.N;
        Coordinate nextPosition = startPosition.nextPosition();
        assertTrue(nextPosition.equals(Coordinate.E));
    }

    @Test
    public void lastPositonToFirstPositionTest(){
        Coordinate startPosition = Coordinate.W;
        Coordinate nextPosition = startPosition.nextPosition();
        assertTrue(nextPosition.equals(Coordinate.N));
    }

    @Test
    public void previousPositonTest(){
        Coordinate startPosition = Coordinate.S;
        Coordinate previousPositon = startPosition.previousPosition();
        assertTrue(previousPositon.equals(Coordinate.E));
    }

    @Test
    public void firstPositonToLastPositionTest(){
        Coordinate startPosition = Coordinate.N;
        Coordinate previousPositon = startPosition.previousPosition();
        assertTrue(previousPositon.equals(Coordinate.W));
    }
}
