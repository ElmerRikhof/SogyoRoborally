import React from 'react';
import ConveyorTurnDown from './Images/ConveyorBeltTurnDown.png'; 


interface ConveyorBeltTurnDownProps {
}

const ConveyorBeltTurnDown: React.FC<ConveyorBeltTurnDownProps> = () => {

  const src = ConveyorTurnDown;
 
  return (
    <div >
      <img src={src} alt={`ConveyorBeltTurnDown`} width={50} height={50} />
    </div>
  );
}

export default ConveyorBeltTurnDown;