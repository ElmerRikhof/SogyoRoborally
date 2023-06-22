import React from "react";
import { GameState } from '../../types/gameState';
import './GameBoard.css'; 
import GreyTile from './Tiles/GreyTile';
import WallVerticalTile from './Tiles/WallVertical';
import Player1 from './Robots/PlayerOne';
import Player2 from './Robots/PlayerTwo';
import WallHorizontaal from './Tiles/WallHorizontal';
import ClockwiseGear from './Tiles/ClockwiseGear';
import CounterClockwiseGear from './Tiles/CounterClockwiseGear';
import Hole from './Tiles/Hole';
import SingleWrench from './Tiles/SingleWrench';
import DoubleWrench from './Tiles/DoubleWrench';
import ConveyorBeltDown from './Tiles/ConveyorBeltDown';
import ConveyorBeltLeft from './Tiles/ConveyorBeltLeft';
import ConveyorBeltRight from './Tiles/ConveyorBeltRight';
import ConveyorBeltUp from './Tiles/Conveyorbelt';
import ConveyorBeltTurnUp from './Tiles/ConveyorBeltTurnUp';
import ConveyorBeltTurnDown from './Tiles/ConveyorBeltTurnDown';
import ConveyorBeltTurnLeft from './Tiles/ConveyorBeltTurn';
import ConveyorBeltTurnRight from './Tiles/ConveyorBeltTurnRight';
import Flag from './Tiles/Flag';


interface Props {
  gameState: GameState
  images: string[]; // Array of image paths
}

const GameBoard: React.FC<Props> = ({gameState, images}) => {

  const tiles: number[][] = gameState.map.map

  function renderTile(value: number) {
    switch (value) {
      case 0:
        return <Grey />;
      case 1:
        return <WallVertical/>;
      case 2:
        return <WallHorizontaal/>;
      case 3:
        return <ClockwiseGear/>;
      case 4:
        return <CounterClockwiseGear/>;
      case 5:
        return <ConveyorBeltUp/>;
      case 6:
        return <ConveyorBeltDown/>;
      case 7:
        return <ConveyorBeltLeft/>;
      case 8:
        return <ConveyorBeltRight/>;
      case 9:
        return <ConveyorBeltTurnUp/>;
      case 10:
        return <ConveyorBeltTurnDown/>;
      case 11:
        return <ConveyorBeltTurnLeft/>;
      case 12:
        return <ConveyorBeltTurnRight/>;
      case 13:
        return <Hole/>;
      case 14:
        return <SingleWrench/>;
      case 15:
        return <DoubleWrench/>;
      case 16:
        return <Flag/>;
      default:
        return null;
    }
  }

  return (
    <>
    <div className='grid-container-container'>
      <div className="grid-container">
        {tiles.map((row, i) => (
          <div className="row" key={i}>
            {row.map((value, j) => (
              <div className="tile" key={j}>
                {renderTile(value)}
              </div>
            ))}
          </div>
        ))}
          {<Player1 gameState={gameState}/> }
          {<Player2 gameState={gameState}/> } 
      </div>
    </div>  
    </>
  );
}



function Grey() {
  return <GreyTile />;
}

function WallVertical() {
  return <div><WallVerticalTile/></div>;
}
export default GameBoard;
