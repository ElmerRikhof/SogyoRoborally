import React from 'react';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Menu from '../components/Header/Menu';
import { Roborally } from '../components/Roborally/Roborally';
import Registration from '../components/Login/Registration';
import { LoginState } from '../types/loginState';

export default function App() {

  return (
    <>
      <Router>
        <Menu />
          <Routes>
             <Route path='/' element={<Roborally/>} />
          </Routes>
          <Routes>
            <Route path='/login' element={<Registration setLoginState={function (value: React.SetStateAction<LoginState | undefined>): void {
            throw new Error('Function not implemented.');
          } }/>} />
          </Routes>
      </Router>
    </>
  )
}