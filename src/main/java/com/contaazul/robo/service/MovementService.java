package com.contaazul.robo.service;

import com.contaazul.robo.model.Coordinate;
import com.contaazul.robo.model.Movement;
import com.contaazul.robo.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MovementService.class);

    private CommandService commandService;

    @Autowired
    public MovementService(CommandService commandService) {
        this.commandService = commandService;
    }

    public Robot moveRobot(final String command,final Robot robot){
        LOGGER.info("Initiating process of movement");
        final List<String> commands = commandService.splitCommand(command);
        commands.forEach(c -> processMove(c, robot));
        LOGGER.info(robot.toString());
        return robot;
    }

    private void processMove(final String command, final Robot robot) {
        LOGGER.info("Initiating process of movement to command {}", command);
        MovementType movement = selectMovementType(command);
        movement.execute(command, robot);

    }

    private MovementType selectMovementType(final String command) {
        if(command.equals(Movement.M.name())){
            return new AccelarationMovementType();
        }else{
            return new RotationMovementType();
        }
    }


}
