import React from 'react';
import Flag from './Images/Flag.png'; 
import './Tiles.css';
import Square from './Images/Square.png'; 


interface FlagProps {
}

const Wall_Horizontaal: React.FC<FlagProps> = () => {

  const src = Flag;
  const square = Square;

  return (
  <div className='Size'>
    <img className='Flag' src={src} alt={`Flag`} width={50} />
    <img className='Square' src={square} alt={`Square`} width={50} height={50}/>
  </div>
  );
}

export default Wall_Horizontaal;