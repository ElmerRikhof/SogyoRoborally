import React from 'react';
import Wall from './Images/Wall.png'; 
import './Tiles.css';
import Square from './Images/Square.png'; 
// import { isAbsolute } from 'path';


interface WallVerticalProps {
}

const WallVerticalTile: React.FC<WallVerticalProps> = () => {

    const wall = Wall;
    const square = Square;
 
  return (
   <div className='Size'>
    <img className='WallH' src={wall} alt={`WallH`} height={50} />
    <img className='Square' src={square} alt={`Square`} width={50} height={50}/>
  </div>
   
  );
}

export default WallVerticalTile;