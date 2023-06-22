import React from 'react';
import PlayerOne from './Images/Daco_34602.png'; 
import { GameState } from '../../../types/gameState';


interface PlayerOneProps {
  gameState: GameState
}

const Player1: React.FC<PlayerOneProps> = ({gameState}) => {

  const src = PlayerOne;

  const getRotation = () => {
    switch (gameState.robot1.rotation) {
      default:
      return gameState.robot1.rotation;
    }
  };

  return (
   <>
    <div className='playerOne'>

      <img src={src} alt={`Player1`} width={50} height={50} 
        style={{
            position: 'absolute',
            left: gameState.robot1.x * 50,
            top: gameState.robot1.y *50,
            transform: `rotate(${getRotation()}deg)`,
            transition: 'left 1.5s ease, top 1.5s ease, transform 1.5s ease',
         }}/>
    </div>
   </>
  );
}

export default Player1;