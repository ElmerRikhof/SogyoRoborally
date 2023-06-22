package roborally.domain;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    //robots p1/p2
    private String name;
    private Robot tegenspeler;
    private Board map;
    private int yPosition;
    private int xPosition;
    private String facing;
    private int rotation;
    private CardDeck cards;


    public CardDeck getCards() {
        return cards;
    }

    public void setCards(CardDeck cards) {
        this.cards = cards;
    }

    public String getName(){
        return name;
    }

    public Robot getTegenspeler(){
        return tegenspeler;
    }

    public Board getMap(){
        return map;
    }

    public int getY(){
        return yPosition;
    }

    public int getX(){
        return xPosition;
    }

    public String getFacing(){
        return facing;
    }

    public int getRotation(){
        return rotation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTegenspeler(Robot tegenspeler) {
        this.tegenspeler = tegenspeler;
    }

    public void setMap(Board map) {
        this.map = map;
    }

    public void setY(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setX(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }
    public void setRotation(int rotation){
        this.rotation = rotation;
    }


    public Robot(String name, String opponentName, Board map, CardDeck cards){ 
        this.facing = "North";
        this.rotation = 0;
        this.yPosition = 14;
        this.xPosition = 6;
        this.name = name;
        this.map = map;
        Robot firstPlayer = this;
        this.tegenspeler = new Robot(opponentName, firstPlayer, map, cards);
    }

    public Robot(String name, Robot opponent, Board map, CardDeck cards){
        this.facing = "North";
        this.rotation = 0; 
        this.yPosition = 14;
        this.xPosition = 7;
        this.name = name;
        this.map = map;
        this.tegenspeler = opponent;
    }


//    private List<Robot> robot1moves;

//     public List<Robot> getRobot1moves() {
//     return robot1moves;
// }

// public void setRobot1moves(List<Robot> robot1moves) {
//     this.robot1moves = robot1moves;
// }

//     public void addMoves(){
//         robot1moves.add(tegenspeler);
//     }


    //value tiles
    public int getValue(int rowIndex, int columnIndex) {

        if (rowIndex >= 0 && rowIndex < map.getMap().length && columnIndex >= 0 && columnIndex < map.getMap()[rowIndex].length) {
            return map.getMap()[rowIndex][columnIndex];
        } else {
            throw new IndexOutOfBoundsException("Invalid index values.");
        }
    }


    //cards
    public void MoveOne() {
    
        switch (getFacing()) {
            case "North":
                if(getY()-1 != tegenspeler.getY() ||  getX() != tegenspeler.getX()){
                    doActionFaceNorth(getValue(getY()-1, getX()));
               
                    System.out.println("N1");
                }
                else if(getY()-1 == tegenspeler.getY() &&  getX() == tegenspeler.getX() && (tegenspeler.getValue(getY()-1, tegenspeler.getX()) == 1 || tegenspeler.getValue(getY()-1, tegenspeler.getX()) == 2 )){
                
                    System.out.println("N2");
                }
                else if(getY()-1 == tegenspeler.getY() &&  getX() == tegenspeler.getX() && (tegenspeler.getValue(getY()-1, tegenspeler.getX()) != 1 || tegenspeler.getValue(getY()-1, tegenspeler.getX()) != 2 )){
                    doActionFaceNorth(getValue(getY()-1, getX()));
                    tegenspeler.doActionFaceNorth(getValue(getY()-1, getX()));
                
                    System.out.println("N3");
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "South":
                if(getY()+1 != tegenspeler.getY() ||  getX() != tegenspeler.getX()){
                    doActionFaceSouth(getValue(getY()+1, getX())); 
                  
                    System.out.println("S1");
                } 
                else if(getY()+1 == tegenspeler.getY() &&  getX() == tegenspeler.getX()  && (tegenspeler.getValue(getY()+1, tegenspeler.getX()) == 1 || tegenspeler.getValue(getY()+1, tegenspeler.getX()) == 2 )){ 
                    System.out.println("S2");
                  
                } 
                else if(getY()+1 == tegenspeler.getY() &&  getX() == tegenspeler.getX()  && (tegenspeler.getValue(getY()+1, tegenspeler.getX()) != 1 || tegenspeler.getValue(getY()+1, tegenspeler.getX()) != 2 )){
                    doActionFaceSouth(getValue(getY()+1, getX()));
                    tegenspeler.doActionFaceSouth(getValue(getY()+1, getX()));  
                    System.out.println("S3");
             
                } 
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
             case "East":
                if (getY() != tegenspeler.getY() ||  getX()+1 != tegenspeler.getX()){
                     doActionFaceEast(getValue(getY(), getX()+1));
                     
                     System.out.println("E1");
                } 
                else if (getY() == tegenspeler.getY() &&  getX()+1 == tegenspeler.getX() && (tegenspeler.getValue(getY(), tegenspeler.getX()+1) == 1 || tegenspeler.getValue(getY(), tegenspeler.getX()+1) == 2 )){
                    System.out.println("E2");
                   
                } 
                else if (getY() == tegenspeler.getY() &&  getX()+1 == tegenspeler.getX() && (tegenspeler.getValue(getY(), tegenspeler.getX()+1) != 1 || tegenspeler.getValue(getY(), tegenspeler.getX()+1) != 2 )){
                    doActionFaceEast(getValue(getY(), getX()+1));
                    tegenspeler.doActionFaceEast(getValue(getY(), getX()+1));
                
                    System.out.println("E3");
                } 
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "West":
                if (getY() != tegenspeler.getY() ||  getX()-1 != tegenspeler.getX()){
                    doActionFaceWest(getValue(getY(), getX()-1));
                    System.out.println("W1");
                 
                } 
                else if (getY() == tegenspeler.getY() &&  getX()-1 == tegenspeler.getX() && (tegenspeler.getValue(getY(), getX()-1) == 1 || tegenspeler.getValue(getY(), getX()-1) == 2 )){
                    System.out.println("W2");
                         
                } 
                else if (getY() == tegenspeler.getY() &&  getX()-1 == tegenspeler.getX() && (tegenspeler.getValue(getY(), getX()-1) != 1 || tegenspeler.getValue(getY(), getX()-1) != 2 )){
                    doActionFaceWest(getValue(getY(), getX()-1));
                    tegenspeler.doActionFaceWest(getValue(getY(), getX()-1));
                                    
                    System.out.println("W3");
                } 
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void TurnRight() {
    
        switch (getFacing()) {
            case "North":
                setFacing("East");
                setRotation(getRotation() + 90);
                break;
            case "East":
                setFacing("South");
                setRotation(getRotation() + 90);
             
                break;
            case "South":
                setFacing("West");
                setRotation(getRotation() + 90);
               
                break;
            case "West":
                setFacing("North");
                setRotation(getRotation() + 90);
               
                break;
        }
    }

    public void TurnLeft() {
    
        switch (getFacing()) {
            case "North":
                setFacing("West");
                setRotation(getRotation() - 90);
              
                break;
            case "East":
                setFacing("North");
                setRotation(getRotation() - 90);
              
                break;
            case "South":
                setFacing("East");
                setRotation(getRotation() - 90);
                
                break;
            case "West":
                setFacing("South");
                setRotation(getRotation() - 90);
               
                break;
        }
    }

    public void TurnAround() {
    
        switch (getFacing()) {
            case "North":
                setFacing("South");
                setRotation(getRotation() - 180);
                
                break;
            case "East":
                setFacing("West");
                setRotation(getRotation() - 180);
               
                break;
            case "South":
                setFacing("North");
                setRotation(getRotation() + 180);
               
                break;
            case "West":
                setFacing("East");
                setRotation(getRotation() + 180);
                break;
        }
    }


    //actions
    public void doActionFaceNorth(int value){

        if (value == 0 || value == 14 || value == 15  || value == 16){
            setY( getY() - 1);// 0 = grey square
        }
        if (value == 1){
            setY( getY() - 0);// 1 = Wall vertical
        }
        if (value == 2){
            setY( getY() - 0); // 2 = Wall horizontal
        }
        if (value == 3){
            setY( getY() - 1);  // 3 = ClockwisGear
            clockwiseGear();
        }
        if (value == 4){
            setY( getY() - 1); // 4 = CounterclockwiseGear
            counterClockwiseGear();
        }
        if (value == 5){
            setY( getY() - 1);// 5= ConveyorBeltUp
            if (getValue(getY(), getX()) == 5){
                beltUp();
            }
        }
        if (value == 6){
            setY( getY() + 0);// 6 = ConveyorBeltDown
        }
        if (value == 7){
            setY( getY() - 1);// 7 = ConveyorBeltLeft
            if (getValue(getY(), getX()) == 7){
                beltLeft();
            }
        }
        if (value == 8){
            setY( getY() - 1);// 8 = ConveyorBeltRight
            if (getValue(getY(), getX()) == 8){
                beltRight();
            }
        }
        if (value == 9){
            setY( getY() - 1);// 9 = ConveyorBeltTurnUp
            if (getValue(getY(), getX()) == 9){
                beltTurnUp();
            }
        }
        if (value == 10){ // 10 = ConveyoprBeltTurnDown
        }
        if (value == 11){
            setY( getY() - 1);// 11 = ConveyorBeltTurnLeft
            if (getValue(getY(), getX()) == 11){
                beltTurnLeft();
            }
        }
        if (value == 12){
            setY( getY() - 1);// 12 = ConveyorBeltTurnRight
            if (getValue(getY(), getX()) == 12){
                beltTurnRight();
            }
        }
        if (value == 13){
            setY( getY() - 1);// 13 = Hole
            if (getValue(getY(), getX()) == 13){
                setY( 14);
                setX( 7);
            }
        }
    }
    
    public void doActionFaceSouth(int value){

        if (value == 0 || value == 14 || value == 15  || value == 16){
            setY( getY() + 1);// 0 = grey square
        }
        if (value == 1){
            setY( getY() + 0);// 1 = Wall vertical
        }
        if (value == 2){
            setY( getY() + 0); // 2 = Wall horizontal
        }
        if (value == 3){
            setY( getY() + 1);  // 3 = ClockwisGear
            clockwiseGear();
        }
        if (value == 4){
            setY( getY() + 1); // 4 = CounterclockwiseGear
            counterClockwiseGear();
        }
        if (value == 5){
            setY( getY() + 0);// 5= ConveyorBeltUp
        }
        if (value == 6){
            setY( getY() + 1);// 6 = ConveyorBeltDown
            if (getValue(getY(), getX()) == 6){
                beltDown();
            }
        }
        if (value == 7){
            setY( getY() + 1);// 7 = ConveyorBeltLeft
            if (getValue(getY(), getX()) == 7){
                beltLeft();
            }
        }
        if (value == 8){
            setY( getY() + 1);// 8 = ConveyorBeltRight
            if (getValue(getY(), getX()) == 8){
                beltRight();
            }
        }
        if (value == 9){
        
        }
        if (value == 10){
            setY( getY() + 1);// 10 = ConveyorBeltTurnDown
            if (getValue(getY(), getX()) == 10){
                beltTurnDown();
            }
        }
        if (value == 11){
            setY( getY() + 1);// 8 = ConveyorBeltTurnLeft
            if (getValue(getY(), getX()) == 11){
                beltTurnLeft();
            }
        }
        if (value == 12){
            setY( getY() + 1);// 8 = ConveyorBeltTurnRight
            if (getValue(getY(), getX()) == 12){
                beltTurnRight();
            }
        }
        if (value == 13){
            setY( getY() + 1);// 13 = Hole
            if (getValue(getY(), getX()) == 13){
                setY( 14);
                setX( 7);
            }
        }
        if (value == 16){
           //winner  // 16 = flag
        }
    }

    public void doActionFaceEast(int value){

        if (value == 0 || value == 14 || value == 15  || value == 16){
            setX(getX() + 1);// 0 = grey square
        }
        if (value == 1){
            setX( getX() - 0);// 1 = Wall vertical
        }
        if (value == 2){
            setX( getX() - 0);// 1 = Wall vertical
        }
        if (value == 3){
            setX(getX() + 1);  // 3 = ClockwisGear
            clockwiseGear();
        }
        if (value == 4){
            setX(getX() + 1); // 4 = CounterclockwiseGear
            counterClockwiseGear();
        }
        if (value == 5){
            setX(getX() + 1);// 5= ConveyorBeltUp
            if (getValue(getY(), getX()) == 5){
                beltUp();
            }
        }
        if (value == 6){
            setX(getX() + 1);// 6 = ConveyorBeltDown
            if (getValue(getY(), getX()) == 6){
                beltDown();
            }
        }
        if (value == 7){
            setX(getX() + 0);// 7 = ConveyorBeltLeft
        }
        if (value == 8){
            setX(getX() + 1);// 8 = ConveyorBeltRight
            if (getValue(getY(), getX()) == 8){
                beltRight();
            }
        }
        if (value == 9){
            setX( getX() + 1);// 9 = ConveyorBeltTurnUp
            if (getValue(getY(), getX()) == 9){
                beltTurnUp();
            }
        }
        if (value == 10){
            setX( getX() + 1);// 10 = ConveyorBeltTurnDown
            if (getValue(getY(), getX()) == 10){
                beltTurnDown();
            }
        }
        if (value == 11){
          
        }
        if (value == 12){
            setX( getX() + 1);// 8 = ConveyorBeltTurnRight
            if (getValue(getY(), getX()) == 12){
                beltTurnRight();
            }
        }
        if (value == 13){
            setX(getX() + 1);// 13 = Hole
            if (getValue(getY(), getX()) == 13){
                setX(getX() + 1);
                setY( 14);
                setX( 7);
            }
        }
        if (value == 16){
           //winner  // 16 = flag
        }
    }

    public void doActionFaceWest(int value){

        if (value == 0 || value == 14 || value == 15  || value == 16){
            setX(getX() - 1);// 0 = grey square
        }
        if (value == 1){
            setX( getX() - 0);// 1 = Wall vertical
        }
        if (value == 2){
            setX( getX() - 0);// 1 = Wall vertical
        }
        if (value == 3){
            setX(getX() - 1);  // 3 = ClockwisGear
            clockwiseGear();
        }
           
        if (value == 4){
            setX(getX() - 1); // 4 = CounterclockwiseGear
            counterClockwiseGear();
        }
        if (value == 5){
            setX(getX() - 1);// 5= ConveyorBeltUp
            if (getValue(getY(), getX()) == 5){
                beltUp();
            }
        }
        if (value == 6){
            setX(getX() - 1);// 6 = ConveyorBeltDown
            if (getValue(getY(), getX()) == 6){
                beltDown();
            }
        }
        if (value == 7){
            setX(getX() - 1);// 7 = ConveyorBeltLeft
            if (getValue(getY(), getX()) == 7){
                beltLeft();
            }
        }
        if (value == 8){
            setX(getX() + 0);// 8 = ConveyorBeltRight
        }
        if (value == 9){
            setX( getX() - 1);// 9 = ConveyorBeltTurnUp
            if (getValue(getY(), getX()) == 9){
                beltTurnUp();
            }
        }
        if (value == 10){
            setX( getX() - 1);// 10 = ConveyorBeltTurnDown
            if (getValue(getY(), getX()) == 10){
                beltTurnDown();
            }
        }
        if (value == 11){
            setX( getX() - 1);// 11 = ConveyorBeltTurnLeft
            if (getValue(getY(), getX()) == 11){
                beltTurnLeft();
            }
        }
        if (value == 12){// 12 = ConveyorBeltTurnLeft
        }
        if (value == 13){
            setX(getX() - 1);// 13 = Hole
            if (getValue(getY(), getX()) == 13){
                setX(getX() + 1);
                setY( 14);
                setX( 7);
            }
        }
        if (value == 16){
           //winner  // 16 = flag
        }
    }


    //movements
    public void beltTurnDown(){
        switch (getFacing()) {
            case "North":
                if (getValue(getY(), getX()+1) == 7){
                    setY( getY() + 1);
                    setFacing("West");
                    setRotation(getRotation() - 90);
                } else {
                    setY( getY() + 1);
                }
                break;
            case "East":
                setY( getY() + 1);
                break;
            case "South":
                setY( getY() + 1);
                break;
            case "West":
                setRotation(getRotation() - 90);
                setFacing("South");
                setY( getY() + 1);
                break;
            }
   
        if (getValue(getY(), getX()) == 3){
            clockwiseGear();
        }  
        else if (getValue(getY(), getX()) == 4){
            counterClockwiseGear();
        }
        else if (getValue(getY(), getX()) == 5){
            beltUp();
        } 
        else if (getValue(getY(), getX()) == 6){
            beltDown();
        }  
        else if (getValue(getY(), getX()) == 7){
            beltLeft();
        }  
        else if (getValue(getY(), getX()) == 8){
            beltRight();
        } 
        else if (getValue(getY(), getX()) == 9){
            beltTurnUp();
        } 
        else if (getValue(getY(), getX()) == 11){
            beltTurnLeft();
        }  
        else if (getValue(getY(), getX()) == 12){
            beltTurnRight();
        }  
    }
    
    public void beltTurnUp(){
        switch (getFacing()) {
            case "North":
                setY( getY() - 1);
                break;
            case "East":
                setRotation(getRotation() - 90);
                setFacing("North");
                setY( getY() - 1);
                break;
            case "South":
                if (getValue(getY(), getX()-1) == 8){
                    setY( getY() - 1);
                    setFacing("East");
                    setRotation(getRotation() - 90);
                } else {
                    setY( getY() - 1);
                }
                break;
            case "West":
                setY( getY() - 1);
                break;
            }
   
        if (getValue(getY(), getX()) == 3){
            clockwiseGear();
        }  
        else if (getValue(getY(), getX()) == 4){
            counterClockwiseGear();
        }
        else if (getValue(getY(), getX()) == 5){
            beltUp();
        } 
        else if (getValue(getY(), getX()) == 6){
            beltDown();
        }  
        else if (getValue(getY(), getX()) == 7){
            beltLeft();
        }  
        else if (getValue(getY(), getX()) == 8){
            beltRight();
        } 
        else if (getValue(getY(), getX()) == 10){
            beltTurnDown();
        } 
        else if (getValue(getY(), getX()) == 11){
            beltTurnLeft();
        }  
        else if (getValue(getY(), getX()) == 12){
                beltTurnRight();
        }  
    }

    public void beltTurnLeft(){
        switch (getFacing()) {
            case "North":
                setRotation(getRotation() - 90);
                setFacing("West");
                setX( getX() - 1);
                break;
            case "East":
                if (getValue(getY()+1, getX()) == 5){
                    setX( getX() - 1);
                    setFacing("North");
                    setRotation(getRotation() - 90);
                } else {
                    setX( getX() - 1);
                }
                break;
            case "South":
                setX( getX() - 1);
                break;
            case "West":
                setX( getX() - 1);
                break;
            }
   
        if (getValue(getY(), getX()) == 3){
            clockwiseGear();
        }  
        else if (getValue(getY(), getX()) == 4){
            counterClockwiseGear();
        }
        else if (getValue(getY(), getX()) == 5){
            beltUp();
        } 
        else if (getValue(getY(), getX()) == 6){
            beltDown();
        }  
        else if (getValue(getY(), getX()) == 7){
            beltLeft();
        }  
        else if (getValue(getY(), getX()) == 8){
            beltRight();
        } 
        else if (getValue(getY(), getX()) == 9){
            beltTurnUp();
        }  
        else if (getValue(getY(), getX()) == 10){
            beltTurnDown();
        }  
        else if (getValue(getY(), getX()) == 12){
                beltTurnRight();
        }  
    }

    public void beltTurnRight(){
        switch (getFacing()) {
            case "North":
                setX( getX() + 1);
                break;
            case "East":
                setX( getX() + 1);
                break;
            case "South":
                setRotation(getRotation() - 90);
                setFacing("East");
                setX( getX() + 1);
                break;
            case "West":
                if (getValue(getY() - 1, getX()) == 6){
                    setX( getX() + 1);
                    setFacing("South");
                    setRotation(getRotation() - 90);
                } else {
                    setX( getX() + 1);
                }
                break;
            }
   
        if (getValue(getY(), getX()) == 3){
            clockwiseGear();
        }  
        else if (getValue(getY(), getX()) == 4){
            counterClockwiseGear();
        }
        else if (getValue(getY(), getX()) == 5){
            beltUp();
        } 
        else if (getValue(getY(), getX()) == 6){
            beltDown();
        }  
        else if (getValue(getY(), getX()) == 7){
            beltLeft();
        }  
        else if (getValue(getY(), getX()) == 8){
            beltRight();
        } 
        else if (getValue(getY(), getX()) == 9){
            beltTurnUp();
        }  
        else if (getValue(getY(), getX()) == 10){
            beltTurnDown();
        }   
        else if (getValue(getY(), getX()) == 11){
            beltTurnLeft();
        }  
    }

    public void beltUp(){
        setY( getY() - 1);
        if (getValue(getY(), getX()) == 5){
            beltUp();
        } 
        else if (getValue(getY(), getX()) == 3){
            clockwiseGear();
        }  
        else if (getValue(getY(), getX()) == 4){
            counterClockwiseGear();
        }
        else if (getValue(getY(), getX()) == 7){
            beltLeft();
        }  
        else if (getValue(getY(), getX()) == 8){
            beltRight();
        }  
        else if (getValue(getY(), getX()) == 9){
            beltTurnUp();
        }  
        else if (getValue(getY(), getX()) == 10){
            beltTurnDown();
        }  
        else if (getValue(getY(), getX()) == 11){
            beltTurnLeft();
        }  
        else if (getValue(getY(), getX()) == 12){
            beltTurnRight();
        }  
    }

    public void beltDown(){
        setY( getY() + 1);
        if (getValue(getY(), getX()) == 6){
            beltDown();
        }  
        else if (getValue(getY(), getX()) == 3){
            clockwiseGear();
        }  
        else if (getValue(getY(), getX()) == 4){
            counterClockwiseGear();
        } 
        else if (getValue(getY(), getX()) == 7){
            beltLeft();
        }  
        else if (getValue(getY(), getX()) == 8){
            beltRight();
        } 
        else if (getValue(getY(), getX()) == 9){
            beltTurnUp();
        }  
        else if (getValue(getY(), getX()) == 10){
            beltTurnDown();
        }  
        else if (getValue(getY(), getX()) == 11){
            beltTurnLeft();
        }  
        else if (getValue(getY(), getX()) == 12){
            beltTurnRight();
        }  
    }

    public void beltLeft(){
        setX( getX() - 1); 
        if (getValue(getY(), getX()) == 7){
            beltLeft();
        } 
        else if (getValue(getY(), getX()) == 3){
            clockwiseGear();
        }  
        else if (getValue(getY(), getX()) == 4){
            counterClockwiseGear();
        }
        else if (getValue(getY(), getX()) == 5){
            beltUp();
        } 
        else if (getValue(getY(), getX()) == 6){
            beltDown();
        }
        else if (getValue(getY(), getX()) == 9){
            beltTurnUp();
        }  
        else if (getValue(getY(), getX()) == 10){
            beltTurnDown();
        }  
        else if (getValue(getY(), getX()) == 11){
            beltTurnLeft();
        }  
        else if (getValue(getY(), getX()) == 12){
            beltTurnRight();
        }    
    }

    public void beltRight(){
        setX( getX() + 1);
        if (getValue(getY(), getX()) == 8){
            beltRight();
        }
        else if (getValue(getY(), getX()) == 3){
            clockwiseGear();
        }  
        else if (getValue(getY(), getX()) == 4){
            counterClockwiseGear();
        }
        else if (getValue(getY(), getX()) == 5){
            beltUp();
        } 
        else if (getValue(getY(), getX()) == 6){
            beltDown();
        }
        else if (getValue(getY(), getX()) == 9){
            beltTurnUp();
        }  
        else if (getValue(getY(), getX()) == 10){
            beltTurnDown();
        }  
        else if (getValue(getY(), getX()) == 11){
            beltTurnLeft();
        }  
        else if (getValue(getY(), getX()) == 12){
            beltTurnRight();
        }  
    }

    public void clockwiseGear(){ 
        switch (getFacing()) {
            case "North":
                setFacing("East");
                setRotation( getRotation() + 90);
                break;
            case "East":
                setFacing("South");
                setRotation(getRotation() + 90);
                break;
            case "South":
                setFacing("West");
                setRotation(getRotation() + 90);
                break;
            case "West":
                setFacing("North");
                setRotation( getRotation() + 90); 
                break;
        }
    }

    public void counterClockwiseGear(){ 

        switch (getFacing()) {
            case "North":
                setFacing("West");
                setRotation( getRotation() - 90);
                break;
            case "East":
                setFacing("North");
                setRotation(getRotation() - 90);
                break;
            case "South":
                setFacing("East");
                setRotation(getRotation() - 90);
                break;
            case "West":
                setFacing("South");
                setRotation( getRotation() - 90); 
                break;
        }
    }
}



