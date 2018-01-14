package com.contaazul.robo.service;

import com.contaazul.robo.model.Land;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LandService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MovementService.class);

    private Land land;

    public LandService() {
        this.land = new Land();
    }


    public void test(){
        land.getMap();
    }
}
