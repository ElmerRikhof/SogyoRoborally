import React, { useState } from 'react';
import './Cards.css';

interface MoveOneProps {
  onClick?: () => void; // Define onClick prop as an optional function
}

const MoveOne: React.FC<MoveOneProps> = ({ onClick}) => {
  
  const [isClicked, setIsClicked] = useState(false);

  const handleClick = () => {
    setIsClicked(!isClicked);
    if (onClick) {
      onClick();
    };
  };

  return (
    <button
      className={`moveOneButton ${isClicked ? 'active' : ''}`}
      onClick={handleClick}
    >
      <h4>Move One</h4>
    </button>
  );
};

export default MoveOne;
