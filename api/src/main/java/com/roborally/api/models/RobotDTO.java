package com.roborally.api.models;

import roborally.domain.Robot;

public class RobotDTO {

    private String name;
    private int yPosition;
    private int xPosition;
    private String facing;
    private int rotation;

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getY(){
        return yPosition;
    }

    public void setY(int yPosition){
        this.yPosition = yPosition;
    }
    
    public int getX(){
        return xPosition;
    }

    public void setX(int xPosition){
        this.xPosition = xPosition;
    }
    
    public String getFacing(){
        return facing;
    }

    public void setFacing(String facing){
        this.facing = facing;
    }
    
    public RobotDTO (Robot robot){
        setName(robot.getName());
        setX(robot.getX());
        setY(robot.getY());
        setFacing(robot.getFacing());
        setRotation(robot.getRotation());
    }
}
        