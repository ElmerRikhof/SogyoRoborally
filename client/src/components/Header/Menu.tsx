import React from 'react';
import { Link } from 'react-router-dom';
import './Menu.css';

interface Props {}

const Menu: React.FC<Props> = () => {
  return (
    <nav className="nav" >
      <ul className="ul">
        <li className="li">
          <Link to="/">Home</Link>
        </li>
        <li className="li">
          <Link to="/login">Login</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Menu;