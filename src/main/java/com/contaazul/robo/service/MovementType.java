package com.contaazul.robo.service;

import com.contaazul.robo.model.Robot;

public interface MovementType {

    Robot execute(String command, Robot robot);
}
