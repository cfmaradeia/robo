package com.contaazul.robo.service;

import com.contaazul.robo.exception.InvalidCommandException;
import com.contaazul.robo.exception.InvalidPositionException;
import com.contaazul.robo.model.Coordinate;
import com.contaazul.robo.model.Land;
import com.contaazul.robo.model.Movement;
import com.contaazul.robo.model.Robot;

public class AccelarationMovementType implements MovementType {


    @Override
    public Robot execute(final String command, final Robot robot) {

        if((! command.equals(Movement.M.name())) || (robot == null)){
            throw new InvalidCommandException("Acceleration command not valid or a Robot not is defined.");
        }

        final Coordinate directionRobot = robot.getDirection();

        if(isEnabledMoveToNorth(robot, directionRobot)){
            throw new InvalidPositionException("This movement not is valid. The NORTH limit has been reached.");
        }

        if(isEnabledMoveToSouth(robot, directionRobot)){
            throw new InvalidPositionException("This movement not is valid. The SOUTH limit has been reached.");
        }

        if(isEnabledMoveToWest(robot, directionRobot)){
            throw new InvalidPositionException("This movement not is valid. The WEST limit has been reached.");
        }

        if(isEnabledMoveToEast(robot, directionRobot)){
            throw new InvalidPositionException("This movement not is valid. The EAST limit has been reached.");
        }

        if(directionRobot.equals(Coordinate.N)){
            robot.setY(robot.getY() + 1);
        }
        else if(directionRobot.equals(Coordinate.S)){
            robot.setY(robot.getY() - 1);
        }
        else if(directionRobot.equals(Coordinate.W)){
            robot.setX(robot.getX() + 1);
        }
        else if(directionRobot.equals(Coordinate.E)){
            robot.setX(robot.getX() - 1);
        }

        return robot;
    }



    private boolean isEnabledMoveToNorth(Robot robot, Coordinate directionRobot) {
        return directionRobot.equals(Coordinate.N) && (robot.getY() == Land.Y_POS);
    }

    private boolean isEnabledMoveToSouth(Robot robot, Coordinate directionRobot) {
        return directionRobot.equals(Coordinate.S) && (robot.getY() == 0);
    }

    private boolean isEnabledMoveToWest(Robot robot, Coordinate directionRobot) {
        return directionRobot.equals(Coordinate.W) && (robot.getX() == Land.X_POS);
    }

    private boolean isEnabledMoveToEast(Robot robot, Coordinate directionRobot) {
        return directionRobot.equals(Coordinate.E) && (robot.getX() == 0);
    }
}
