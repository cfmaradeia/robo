package com.contaazul.robo.service;

import com.contaazul.robo.exception.InvalidCommandException;
import com.contaazul.robo.model.Coordinate;
import com.contaazul.robo.model.Movement;
import com.contaazul.robo.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RotationMovementType implements MovementType {

    public static final Logger LOGGER = LoggerFactory.getLogger(RotationMovementType.class);

    @Override
    public Robot execute(final String command, final Robot robot) {

        if(!(command.equals(Movement.L.name()) || command.equals(Movement.R.name())) || (robot == null)){
            throw new InvalidCommandException("Rotation command not valid or a Robot not is defined.");
        }

        final Coordinate directionRobot = robot.getDirection();

        if(command.equals(Movement.L.name())){
            LOGGER.info("Rotate robot to LEFT");
            robot.setDirection(directionRobot.previousPosition());
        }
        else if(command.equals(Movement.R.name())){
            LOGGER.info("Rotate robot to RIGHT");
            robot.setDirection(directionRobot.nextPosition());
        }

        return robot;

    }
}
