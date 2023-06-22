package com.roborally.api.models;
import java.util.ArrayList;

public class Robot2MovesDTO {

    private ArrayList<RobotDTO> robot2moves;
  
    public ArrayList<RobotDTO> getRobot2moves() {
        return robot2moves;
    }

    public Robot2MovesDTO(ArrayList<RobotDTO> robot2moves) {
        this.robot2moves = robot2moves;
    }
}
