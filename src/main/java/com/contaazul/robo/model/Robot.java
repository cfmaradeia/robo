package com.contaazul.robo.model;

public class Robot implements Cloneable{

    private Integer x;
    private Integer y;
    private Coordinate direction;

    public Robot(){

    }

    public Robot(Integer x, Integer y, Coordinate direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Coordinate getDirection() {
        return direction;
    }

    public void setDirection(Coordinate direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y +"," + direction + ')';
    }
}
