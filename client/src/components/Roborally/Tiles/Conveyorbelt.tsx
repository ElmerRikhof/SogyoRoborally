import React from 'react';
import Conveyor from './Images/ConveyorBeltUp.png'; 


interface ConveyorBeltUpProps {
}

const ConveyorBeltUp: React.FC<ConveyorBeltUpProps> = () => {

  const src = Conveyor;
 
  return (
    <div >
      <img src={src} alt={`ConveyorBeltUp`} width={50} height={50} />
    </div>
  );
}

export default ConveyorBeltUp;