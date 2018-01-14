package com.contaazul.robo.service;

import com.contaazul.robo.exception.InvalidCommandException;
import com.contaazul.robo.model.Movement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class CommandService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommandService.class);

    public List<String> splitCommand(final String command) {
        LOGGER.info("Initiating split command: {}", command);
        if(StringUtils.isEmpty(command)){
            throw new InvalidCommandException("The command can not be a empty");
        }
        final List<String> commands = Arrays.asList(command.split(""));
        validateCommand(commands);
        return commands;
    }


    private void validateCommand(final List<String> commands) {
        LOGGER.info("Initiating validate commands");
        if(CollectionUtils.isEmpty(commands)){
            throw new InvalidCommandException("The command list can not be a empty");
        }

        try {
            commands.forEach(command -> Movement.valueOf(command));
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandException("The command is invalid. " + e.getMessage());
        }
    }
}
