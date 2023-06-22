package com.roborally.api.models;

public class RoborallyDTO {

    private BoardDTO map;
    private RobotDTO robot1;
    private RobotDTO robot2;
    private CardDeckDTO cards;
    private RobotMovesDTO robot1movess;
    private Robot2MovesDTO robot2movess;

    public Robot2MovesDTO getRobot2movess() {
        return robot2movess;
    }

    public void setRobot2movess(Robot2MovesDTO robot2movess) {
        this.robot2movess = robot2movess;
    }

    public RobotMovesDTO getRobot1moves() {
        return robot1movess;
    }

    public void setRobot1moves(RobotMovesDTO robot1movess) {
        this.robot1movess = robot1movess;
    }

    public CardDeckDTO getCards() {
        return cards;
    }

    public void setCards(CardDeckDTO cards) {
        this.cards = cards;
    }

    public BoardDTO getMap() {
        return map;
    }

    public void setBoard(BoardDTO map) {
        this.map = map;
    }

    public RobotDTO getRobot1() {
        return robot1;
    }

    public void setRobot1(RobotDTO robot1) {
        this.robot1 = robot1;
    }

    public RobotDTO getRobot2() {
        return robot2;
    }

    public void setRobot2(RobotDTO robot2) {
        this.robot2 = robot2;
    }
    
    public RoborallyDTO(BoardDTO map, CardDeckDTO cards, RobotDTO robot1, RobotDTO robot2, RobotMovesDTO robot1movess, Robot2MovesDTO robot2movess) {
        this.cards = cards;
        this.map = map;
        this.robot1 = robot1;
        this.robot2 = robot2;
        this.robot1movess = robot1movess;
        this.robot2movess = robot2movess;
    }
}