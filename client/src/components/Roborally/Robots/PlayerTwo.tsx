import React from 'react';
import PlayerTwo from './Images/pngwing.com (1).png'; 
import { GameState } from '../../../types/gameState';


interface PlayerTwoProps {
  gameState: GameState
}

const Player2: React.FC<PlayerTwoProps> = ({ gameState}) => {

    const src = PlayerTwo;

    const getRotation = () => {
      switch (gameState.robot2.rotation) {
          default:
          return gameState.robot2.rotation;
      }
    };
 
  return (
  <div className='playerTwo'>
    <img src={src} alt={`Player2`} width={55} height={55} 
        style={{
            position: 'absolute',
            left: gameState.robot2.x * 50,
            top: gameState.robot2.y *50,
            transform: `rotate(${getRotation()}deg)`,
            transition: 'left 1.5s ease, top 1.5s ease, transform 1.5s ease',
        }}/>
  </div>
  );
}

export default Player2;