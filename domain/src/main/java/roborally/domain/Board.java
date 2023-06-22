package roborally.domain;

public class Board {

    // 0 = grey square
    // 1 = Wall vertical
    // 2 = Wall horizontal
    // 3 = ClockwisGear
    // 4 = CounterclockwiseGear
    // 5= ConveyorBeltUp
    // 6 = ConveyorBeltDown
    // 7 = ConveyorBeltLeft
    // 8 = ConveyorBeltRight
    // 9 = ConveyorBeltTurnUp
    // 10 = ConveyorBeltTurnDown
    // 11 = ConveyorBeltTurnLeft
    // 12 = ConveyorBeltTurnRight
    // 13 = Hole
    // 14 = SingleWrench
    // 15 = DoubleWrench
    // 16 = flag

    // private int[][] map= {  
    //     {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10, 11, 12, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    //     {0, 2, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 0},
    // };

    private int[][] map= {  
        {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
        {1, 10, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 13, 1},
        {1, 6, 14, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 1},
        {1, 0, 12, 8, 8, 0, 16, 0, 0, 0, 15, 0, 0, 1},
        {1, 0, 5, 0, 2, 2, 2, 2, 0, 0, 7, 7, 11, 1},
        {1, 0, 5, 0, 0, 0, 0, 0, 0, 4, 0, 0, 5, 1},
        {1, 0, 5, 3, 0, 7, 7, 11, 0, 0, 14, 0, 5, 1},
        {1, 0, 2, 2, 5, 0, 1, 5, 1, 0, 2, 2, 5, 1},
        {1, 0, 0, 0, 5, 0, 1, 5, 1, 0, 3, 15, 5, 1},
        {1, 0, 4, 0, 5, 0, 1, 5, 1, 0, 0, 0, 5, 1},
        {1, 0, 0, 0, 5, 0, 1, 5, 1, 0, 0, 0, 5, 1},
        {1, 0, 0, 15, 5, 0, 1, 5, 1, 0, 0, 0, 5, 1},
        {1, 0, 14, 0, 3, 0, 4, 0, 0, 0, 4, 0, 5, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 9, 1},
        {0, 2, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 0},
    };

    public int[][] getMap(){
        return map;
    }

    public String toString(){
        return map + " ";
    }
    
    public Board() {
     
    }
}
