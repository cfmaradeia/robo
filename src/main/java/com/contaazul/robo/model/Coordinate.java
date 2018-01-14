package com.contaazul.robo.model;

public enum Coordinate {
    N(1),S(2),E(3),W(4);

    private final Integer key;

    Coordinate(Integer key){
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }
}
