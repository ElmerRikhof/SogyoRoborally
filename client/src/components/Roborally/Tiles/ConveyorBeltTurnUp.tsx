import React from 'react';
import ConveyorTurnUp from './Images/ConveyorBeltTurnUp.png'; 


interface ConveyorBeltTurnUpProps {
}

const ConveyorBeltTurnUp: React.FC<ConveyorBeltTurnUpProps> = () => {

  const src = ConveyorTurnUp;
 
  return (
    <div >
      <img src={src} alt={`ConveyorBeltTurnUp`} width={50} height={50} />
    </div>
  );
}

export default ConveyorBeltTurnUp;