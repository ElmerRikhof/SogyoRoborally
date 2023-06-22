export type GameState = {
    gameStatus: {
    };
    map: {map: number[][]};
    cards: {randomStrings: string[], randomStringsP2: string[]};
    robot1:{
        name: string;
        facing: string;
        rotation: number;
        y: number;
        x: number;
        }
    robot2:{
        name: string;
        facing: string;
        rotation: number;
        y: number;
        x: number;
    }

    robot1moves: {
        robot1moves: RobotMove[];
    };
};

type RobotMove = {
    name: string;
    facing: string;
    rotation: number;
    y: number;
    x: number;
};

