import React from 'react';
import CounterClockwise from './Images/CounterClockwiseGear.png'; 


interface CounterClockwiseGearProps {
}

const CounterClockwiseGear: React.FC<CounterClockwiseGearProps> = () => {

  const src = CounterClockwise;
 
  return (
    <div >
      <img src={src} alt={`CounterClockwiseGear`} width={50} height={50} />
    </div>
  );
}

export default CounterClockwiseGear;