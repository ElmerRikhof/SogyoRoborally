import React from 'react';
import Hol from './Images/Hole.png'; 


interface HoleProps {
}

const Hole: React.FC<HoleProps> = () => {

  const src = Hol;
 
  return (
    <div >
      <img src={src} alt={`Hole`} width={50} height={50} />
    </div>
  );
}

export default Hole;