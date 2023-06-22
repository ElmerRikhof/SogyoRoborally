import React from 'react';
import ConveyorRight from './Images/ConveyorBelt.png'; 


interface ConveyorBeltRightProps {
}

const ConveyorBeltRight: React.FC<ConveyorBeltRightProps> = () => {

  const src = ConveyorRight;
 
  return (
    <div >
      <img src={src} alt={`ConveyorBeltRight`} width={50} height={50} />
    </div>
  );
}

export default ConveyorBeltRight;