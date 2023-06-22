package com.roborally.api.models;
import java.util.ArrayList;

public class RobotMovesDTO {

    private ArrayList<RobotDTO> robot1moves;
  
    public ArrayList<RobotDTO> getRobot1moves() {
        return robot1moves;
    }

    public RobotMovesDTO(ArrayList<RobotDTO> robot1moves) {
        this.robot1moves = robot1moves;
    }
}
