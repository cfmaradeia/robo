package com.contaazul.robo.model;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public enum Coordinate {
    N(1),E(2),S(3),W(4);

    private final static Map<Integer, Coordinate> map = stream(Coordinate.values())
                                                                .collect(toMap(c -> c.key, c -> c));

    private final Integer key;

    Coordinate(Integer key){
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public Coordinate nextPosition(){

        final Integer actualKey = this.getKey();

        if(actualKey == 4){
            return Coordinate.N;
        }

        final Integer nextPosition = actualKey + 1;
        return map.get(nextPosition);
    }

    public Coordinate previousPosition(){

        final Integer actualKey = this.getKey();

        if(actualKey == 1){
            return Coordinate.W;
        }

        final Integer previousPosition = actualKey - 1;
        return map.get(previousPosition);
    }
}
