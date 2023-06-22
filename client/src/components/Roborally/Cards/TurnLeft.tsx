import React, {useState} from 'react';


interface MoveOneProps {
  onClick?: () => void; // Define onClick prop as an optional function
}

const TurnLeft: React.FC<MoveOneProps> = ({ onClick }) => {
  
  const [isClicked, setIsClicked] = useState(false);

  const handleClick = () => {
    setIsClicked(!isClicked);
    
    if (onClick) {
      onClick();
    }
  };

  return (
    <button  className={`moveOneButton ${isClicked ? 'active' : ''}`}
    onClick={handleClick}>
      <h4>Turn Left</h4>
    </button>
  );
}

export default TurnLeft;