import React from 'react';
import ConveyorDown from './Images/ConveyorBeltDown.png'; 


interface ConveyorBeltDownProps {
}

const ConveyorBeltDown: React.FC<ConveyorBeltDownProps> = () => {

  const src = ConveyorDown;
 
  return (
    <div >
      <img src={src} alt={`ConveyorBeltDown`} width={50} height={50} />
    </div> 
  );
}

export default ConveyorBeltDown;