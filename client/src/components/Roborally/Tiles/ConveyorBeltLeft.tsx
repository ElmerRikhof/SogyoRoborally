import React from 'react';
import ConveyorLeft from './Images/Conveyor BeltLeft.png'; 


interface ConveyorBeltLeftProps {
}

const ConveyorBeltLeft: React.FC<ConveyorBeltLeftProps> = () => {

  const src = ConveyorLeft;
 
  return (
    <div >
      <img src={src} alt={`ConveyorBeltLeft`} width={50} height={50} />
    </div>
  );
}

export default ConveyorBeltLeft;