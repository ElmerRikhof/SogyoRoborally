import React from 'react';
import Single from './Images/SingleWrench.png'; 


interface SingleWrenchProps {
}

const SingleWrench: React.FC<SingleWrenchProps> = () => {

  const src = Single;
 
  return (
    <div >
      <img src={src} alt={`SingleWrench`} width={50} height={50} />
    </div>
  );
}

export default SingleWrench;