import React from 'react';
import Square from './Images/Square.png'; 


interface GreyTileProps {
}

const GreyTile: React.FC<GreyTileProps> = () => {

  const src = Square;
 
  return (
    <div >
      <img src={src} alt={`GreyTile`} width={50} height={50} />
    </div>
  );
}

export default GreyTile;