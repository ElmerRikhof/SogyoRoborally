import React, { useState } from "react";
import { LoginState } from "../../types/loginState";
import Registration from "./Registration";
import Login from "./Login";

/**
 * The base component for the Roborally game. If there's no active game, the `StartGame` component allows
 * users to enter two player names and start a new game.
 * If there's an active game this component holds the game state. This game state can be passed as a prop
 * to child components as needed.
 *
 * Child components can modify the game state by calling the setGameState (which they recieve as prop.)
 */
export function RegistrationState() {
  // useState is a so called React hook.
  // It is used to manage variables. When the setGameState function is called, React updates the UI as needed
  // The call to useState follows the "rules of hooks": https://reactjs.org/docs/hooks-rules.html
  // To check if code you added also follows the rules of hooks, run "npm run lint" in the command line
  const [loginState, setLoginState] = useState<LoginState | undefined>(undefined);

    if (!loginState) {
      return <Registration setLoginState={setLoginState} />;
    }

  return <Login loginState={loginState} setLoginState={setLoginState} />;
}