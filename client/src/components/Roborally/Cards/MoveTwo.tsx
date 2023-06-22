import React, {useState} from 'react';


interface MoveOneProps {
  onClick?: () => void; // Define onClick prop as an optional function
}

const MoveTwo: React.FC<MoveOneProps> = ({ onClick }) => {

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
      <h4>Move two</h4>
    </button>
  );
}

export default MoveTwo;