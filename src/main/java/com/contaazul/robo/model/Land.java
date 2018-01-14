package com.contaazul.robo.model;

public class Land {

    private static final Integer X_SIZE = 5;
    private static final Integer Y_SIZE = 5;

    public static final Integer X_POS = 4;
    public static final Integer Y_POS = 4;

    private Robot[][] map;


    public Land(){
        this.map = new Robot[X_SIZE][Y_SIZE];
    }

    public Robot[][] getMap() {
        return map;
    }
}
