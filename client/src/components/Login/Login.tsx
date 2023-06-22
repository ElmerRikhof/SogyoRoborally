import React, { useState } from 'react';
import { LoginState } from '../../types/loginState';
import "../Roborally/StartGame.css";
import banner from './Images/walle.jpg';


interface LoginProps {
  loginState: LoginState;
  setLoginState(newLoginState: LoginState): void;
}

const src = banner;


export function Login({loginState, setLoginState }: LoginProps) {

const state = loginState;
    // let setLoginState = input.setLoginState
      
    const [errorMessage, setErrorMessage] = useState("");
    const [Name, setName] = useState("");
    const [Password, setPassword] = useState("");
      
    async function TryLogin() {
      if (!Name) {
        setErrorMessage("A name is required");
        return;
      }
      if (!Password) {
        setErrorMessage("A password is required");
        return;
      }
      setErrorMessage("");

      try {
        const response = await fetch("/api/login/post", {
          method: "POST",
          headers: {
          Accept: "application/json",
           "Content-Type": "application/json",   
          },
          body: JSON.stringify({
            // name: Name,
            // password: Password
          }),
      });
       if (response.ok) {
          const loginState = await response.json();
         
          setLoginState(loginState);
          console.error(response.ok);
       
        } else {
            console.error(response.statusText);
        }
        } catch (error) {
          console.error(error);
        }
      }
      
        return (
          <>
            <div     
              style={{
                backgroundImage: `url(${src})`,
                backgroundSize: 'cover',
                backgroundPosition: 'center',
                backgroundAttachment: 'fixed',
                height: '48vh',
                display: 'flex',
                justifyContent: 'flex-start',
                alignItems: 'flex-start',
                flexDirection: 'column',
                padding: '200px',
              }}>
              <div className="container_startgame">
                <input
                  className="input"
                  value={Name}
                  placeholder="Name"
                  onChange={(e) => setName(e.target.value)}
                />
                <input
                  className="input"
                  value={Password}
                  placeholder="Password"
                  onChange={(e) => setPassword(e.target.value)}
                />
                <button className="startGameButton" onClick={() => TryLogin()}>
                  Login now!
                </button>
                  <p className="errorMessage">{errorMessage}</p>
              </div>
            </div>
          </>
        );
      };
   
    export default Login;
      
    

