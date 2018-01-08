package com.contaazul.robo.service;

import com.contaazul.robo.exception.InvalidCommandException;
import com.contaazul.robo.exception.InvalidPositionException;
import com.contaazul.robo.model.Movement;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MovementService {



    public void toMove(String command){
        validateCommand(command);

    }


    private void validateCommand(String command) {
        if(StringUtils.isEmpty(command)){
            throw new InvalidCommandException("The command can not be a empty");
        }

        try {
            Movement.valueOf(command);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandException("The command is invalid");
        }
    }
}
