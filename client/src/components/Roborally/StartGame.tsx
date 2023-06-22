import React, { useState } from 'react';
import { GameState } from '../../types/gameState';
import "./StartGame.css";
import banner from './Images/walle.jpg';

interface StartProps {
  setGameState: React.Dispatch<React.SetStateAction<GameState | undefined>>
}

const src = banner;

function StartGame(input: StartProps) {

    let setGameState = input.setGameState
      
    const [errorMessage, setErrorMessage] = useState("");
    const [RobotOne, setPlayerOne] = useState("");
    const [RobotTwo, setPlayerTwo] = useState("");
      
    async function tryStartGame() {
      if (!RobotOne) {
        setErrorMessage("A name is required for player 1");
        return;
      }
      if (!RobotTwo) {
        setErrorMessage("A name is required for player 2");
        return;
      }
      if (RobotOne === RobotTwo) {
        setErrorMessage("Each player should have a unique name");
        return;
      }
      setErrorMessage("");

      try {
        const response = await fetch("/api/start/post", {
          method: "POST",
          headers: {
          Accept: "application/json",
           "Content-Type": "application/json",
          },
          body: JSON.stringify({
            namerobot1: RobotOne,
            namerobot2: RobotTwo,
          }),
      });
       if (response.ok) {
          const gameState = await response.json();
          console.log(gameState)
          setGameState(gameState);
          console.error(response.ok);
          console.log(gameState);
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
                  value={RobotOne}
                  placeholder="Player 1 name"
                  onChange={(e) => setPlayerOne(e.target.value)}
                />
                <input
                  className="input"
                  value={RobotTwo}
                  placeholder="Player 2 name"
                  onChange={(e) => setPlayerTwo(e.target.value)}
                />
                <button className="startGameButton" onClick={() => tryStartGame()}>
                  Play Roborally! 
                </button>
                  <p className="errorMessage">{errorMessage}</p>
              </div>
            </div>
          </>
        );
      };

    export default StartGame;
      
    