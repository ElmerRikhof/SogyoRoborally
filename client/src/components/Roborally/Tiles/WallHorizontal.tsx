import React from 'react';
import Wall_horizontal from './Images/Wall_Horizontaal.png'; 
import './Tiles.css';
import Square from './Images/Square.png'; 


interface WallHorizontaalProps {
}

const Wall_Horizontaal: React.FC<WallHorizontaalProps> = () => {

  const src = Wall_horizontal;
  const square = Square;

  return (
  <div className='Size'>
    <img className='WallV' src={src} alt={`WallV`} width={50} />
    <img className='Square' src={square} alt={`Square`} width={50} height={50}/>
  </div>
  );
}

export default Wall_Horizontaal;