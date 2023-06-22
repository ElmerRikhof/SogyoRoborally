import React from 'react';
import Clockwise from './Images/ClockwiseGear.png'; 


interface ClockwiseGearProps {
}

const ClockwiseGear: React.FC<ClockwiseGearProps> = () => {

  const src = Clockwise;
 
  return (
    <div >
      <img src={src} alt={`ClockwiseGear`} width={50} height={50} />
    </div>
  );
}

export default ClockwiseGear;