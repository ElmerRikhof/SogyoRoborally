import React from 'react';
import Double from './Images/Double Wrench.png'; 


interface DoubleWrenchProps {
}

const DoubleWrench: React.FC<DoubleWrenchProps> = () => {

  const src = Double;
 
  return (
    <div >
      <img src={src} alt={`DoubleWrench`} width={50} height={50} />
    </div>
  );
}

export default DoubleWrench;