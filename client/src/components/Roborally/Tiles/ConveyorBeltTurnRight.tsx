import React from 'react';
import ConveyorTurnRight from './Images/ConveyorBeltTurnRight.png'; 


interface ConveyorBeltTurnRightProps {
}

const ConveyorBeltTurnRight: React.FC<ConveyorBeltTurnRightProps> = () => {

  const src = ConveyorTurnRight;
 
  return (
    <div >
      <img src={src} alt={`ConveyorTurnRight`} width={50} height={50} />
    </div>
  );
}

export default ConveyorBeltTurnRight;