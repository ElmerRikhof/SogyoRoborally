package com.roborally.api.models;
import roborally.domain.Board;

public class BoardDTO {
    
    private int[][] map;

    public int[][] getMap(){
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public BoardDTO(Board map){
        setMap(map.getMap());
    }
}

  