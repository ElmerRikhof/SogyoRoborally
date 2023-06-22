import React from 'react';
import ConveyorTurn from './Images/Conveyor Belt with Turn.png'; 


interface ConveyorBeltTurnLeftProps {
}

const ConveyorBeltTurnLeft: React.FC<ConveyorBeltTurnLeftProps> = () => {

  const src = ConveyorTurn;
 
  return (
    <div >
      <img src={src} alt={`ConveyorBeltTurnLeft`} width={50} height={50} />
    </div>
  );
}

export default ConveyorBeltTurnLeft;