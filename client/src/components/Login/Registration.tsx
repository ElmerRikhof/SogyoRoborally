import React, { useState } from 'react';
import { LoginState } from '../../types/loginState';
import "../Roborally/StartGame.css";
import banner from './Images/walle.jpg';

interface RegistrationProps {
  setLoginState: React.Dispatch<React.SetStateAction<LoginState | undefined>>
}

const src = banner;

function Registration(input: RegistrationProps) {

    let setLoginState = input.setLoginState
      
    const [errorMessage, setErrorMessage] = useState("");
    const [Name, setName] = useState("");
    const [Email, setEmail] = useState("");
    const [Password, setPassword] = useState("");
      
    async function tryRegistration() {
      if (!Name) {
        setErrorMessage("A name is required");
        return;
      }
      if (!Email) {
        setErrorMessage("An email is required");
        return;
      }
      if (!Password) {
        setErrorMessage("A password is required");
        return;
      }
      if (Name === Email) {
        setErrorMessage("Name and email should be unique");
        return;
      }
      setErrorMessage("");

      try {
        const response = await fetch("/api/database/register", {
          method: "POST",
          headers: {
          Accept: "application/json",
           "Content-Type": "application/json",   
          },
          body: JSON.stringify({
            name: Name,
            email: Email,
            password: Password
          }),
      });
       if (response.ok) {
          const loginState = await response.json();
          console.log(loginState)
          setLoginState(loginState);
          console.error(response.ok);
          console.log(loginState);
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
                  value={Email}
                  placeholder="Email"
                  onChange={(e) => setEmail(e.target.value)}
                />
                <input
                  className="input"
                  value={Password}
                  placeholder="Password"
                  onChange={(e) => setPassword(e.target.value)}
                />
                <button className="startGameButton" onClick={() => tryRegistration()}>
                  Register now!
                </button>
                  <p className="errorMessage">{errorMessage}</p>
              </div>
            </div>
          </>
        );
      };

    export default Registration;
      
    