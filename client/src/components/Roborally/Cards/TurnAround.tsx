import React, {useState} from 'react';


interface MoveOneProps {
  onClick?: () => void; // Define onClick prop as an optional function
}

const TurnAround: React.FC<MoveOneProps> = ({ onClick }) => {

  const [isClicked, setIsClicked] = useState(false);

  const handleClick = () => {
    setIsClicked(!isClicked);
    if (onClick) {
      onClick();
    }
  };

  return (
    <button className={`moveOneButton ${isClicked ? 'active' : ''}`}
    onClick={handleClick}>
       <h4>Turn Around</h4>
    </button>
  );
}

export default TurnAround;