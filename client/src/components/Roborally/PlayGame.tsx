import React, { useState } from "react";
import { GameState } from '../../types/gameState';
import "./PlayGame.css";
import GameBoard from "./GameBoard";
import MoveOne from "./Cards/MoveOne";
import MoveTwo from "./Cards/MoveTwo";
import MoveThree from "./Cards/MoveThree";
import TurnAround from "./Cards/TurnAround";
import TurnLeft from "./Cards/TurnLeft";
import TurnRight from "./Cards/TurnRight";
import banner from './Images/walle.jpg';


interface PlayProps {
  gameState: GameState;
  setGameState(newGameState: GameState): void;
}


export function PlayGame({ gameState, setGameState }: PlayProps) {

  const src = banner;

  //player1
  const [errorMessage, setErrorMessage] = useState("");
  const [commentaryMessage, setCommentaryMessage] = useState("");
  const [winnerMessage, setWinnerMessage] = useState("");
  const [chosenCardsP1, setChosenCardsP1] = useState<string[]>([]); // Updated to an array of strings
  const cardsP1: string[] = gameState.cards.randomStrings;
  // console.log("carddeck p1: " + gameState.cards.randomStrings);
  console.log("chosencardsP1: " + chosenCardsP1);

  function handleCardClickP1(cardValue: string, index: number) {
    // setChosenCards(prevState => [...prevState, cardValue]); // Add the cardValue to chosenCards array
    setChosenCardsP1(prevState => {

        const isExisting = prevState.includes(cardValue + index);
      
        if (isExisting) {
          // Remove the item from the list
          return prevState.filter(item => item !== cardValue + index);
        } else {
          // Add the item to the list
          return [...prevState, cardValue + index];
        }
      });
   
    //   if (prevState.length < 1) {
    //     setCommentaryMessage('King: "The crowd is cheering for ' + gameState.robot1.name + ' !"');
    //     return [...prevState, cardValue];
    //   } 
    //   if (prevState.length < 2) {
    //     setCommentaryMessage('Barry: "Interesting move..."');
    //     return [...prevState, cardValue];
    //   } 
    //   if (prevState.length < 3) {
    //     setCommentaryMessage('King: "' + gameState.robot2.name + ' cheers up the audience! ' + gameState.robot1.name + ' looks not impressed.."');
    //     return [...prevState, cardValue];
    //   } 
    //   if (prevState.length < 4) {
    //     setCommentaryMessage('Barry: "What an evening! What do you think King?"');
    //     return [...prevState, cardValue];
    //   } 
    //   if (prevState.length < 5) {
    //     setCommentaryMessage('Barry: "Genius move! The audience cant wait to see this!"');
    //     return [...prevState, cardValue];
    //   } 
    //   else {
    //     setErrorMessage('Hey ' + gameState.robot1.name + ' you have reached the limit of 5 cards!');
    //     setCommentaryMessage('King: "Oh noo! ' +  gameState.robot1.name + ' looks nervous"');
    //     return prevState;
    //   }
    // });
  };

  const removeAllItemsP1 = () => {
    setChosenCardsP1([]); // Update the state with an empty array
  };
  
  function renderCardsP1(value: string, index: number) {

    switch (value) {
      case "moveone":
        return <MoveOne onClick={() => handleCardClickP1(value, index)}/>; // Pass onClick prop and handleCardClick function
      case "movetwo":
        return <MoveTwo onClick={() => handleCardClickP1(value, index)} />; // Pass onClick prop and handleCardClick function
      case "movethree":
        return <MoveThree onClick={() => handleCardClickP1(value, index)} />; // Pass onClick prop and handleCardClick function
      case "turnleft":
        return <TurnLeft onClick={() => handleCardClickP1(value, index)} />; // Pass onClick prop and handleCardClick function
      case "turnright":
        return <TurnRight onClick={() => handleCardClickP1(value, index)} />; // Pass onClick prop and handleCardClick function
      case "turnaround":
        return <TurnAround onClick={() => handleCardClickP1(value, index)} />; // Pass onClick prop and handleCardClick function
      default:
        return null; // Add default case or handle other values if necessary
    };
  };


  //player2
  const [chosenCards2, setChosenCardsP2] = useState<string[]>([]); // Updated to an array of strings
  const cardsP2: string[] = gameState.cards.randomStringsP2;
  // console.log("cardeck p2: " + gameState.cards.randomStringsP2);
  console.log("chosencardsP2: " + chosenCards2);
    

  function handleCardClickP2(cardValue: string, index: number) {

    setChosenCardsP2(prevState => {
      const isExisting = prevState.includes(cardValue + index);
    
      if (isExisting) {
        // Remove the item from the list

        return prevState.filter(item => item !== cardValue + index);
      } else {
        // Add the item to the list
   
        return [...prevState, cardValue + index];
      }
    });
  

    // // setChosenCardsP2(prevState => [...prevState, cardValue]); // Add the cardValue to chosenCards array
    // setChosenCardsP21(prevState => {
   
    //   if (prevState.length < 1) {
    //     setCommentaryMessage('King: "The crowd is cheering for ' + gameState.robot2.name + ' !"');
    //     return [...prevState, cardValue];
    //   } 
    //   if (prevState.length < 2) {
    //     setCommentaryMessage('Barry: "Interesting move..."');
    //     return [...prevState, cardValue];
    //   } 
    //   if (prevState.length < 3) {
    //     setCommentaryMessage('King: "' + gameState.robot1.name + ' cheers up the audience! ' + gameState.robot2.name + ' looks not impressed.."');
    //     return [...prevState, cardValue];
    //   } 
    //   if (prevState.length < 4) {
    //     setCommentaryMessage('Barry: "What an evening! What do you think King?"');
    //     return [...prevState, cardValue];
    //   } 
    //   if (prevState.length < 5) {
    //     setCommentaryMessage('Barry: "Genius move! The audience cant wait to see this!"');
    //     return [...prevState, cardValue];
    //   } 
    //   else {
    //     setErrorMessage('Hey ' + gameState.robot2.name + ' you have reached the limit of 5 cards!');
    //     setCommentaryMessage('King: "Oh noo! ' +  gameState.robot2.name + ' looks nervous"');
    //     return prevState;
    //   }
    // });
  }

  const removeAllItemsP2 = () => {
    setChosenCardsP2([]); // Update the state with an empty array
  };


  function renderCardsP2(value: string, index: number) {

    switch (value) {
      case "moveone":
        return <MoveOne  onClick={() => handleCardClickP2(value, index)}/>;
      case "movetwo":
        return <MoveTwo onClick={() => handleCardClickP2(value, index)} />;
      case "movethree":
        return <MoveThree  onClick={() => handleCardClickP2(value, index)} />;
      case "turnleft":
        return <TurnLeft  onClick={() => handleCardClickP2(value, index)} />;
      case "turnright":
        return <TurnRight  onClick={() => handleCardClickP2(value, index)} />;
      case "turnaround":
        return <TurnAround  onClick={() => handleCardClickP2(value, index)} />;
      default:
        return null; // Add default case or handle other values if necessary
    }

  }


  function checkIndexP1(value: string){

    const myList = chosenCardsP1;
    const indexNumber = myList.findIndex((searchItem) => searchItem === value);
    console.log(indexNumber); 
      
    return indexNumber +1;
  }


  function checkIndexP2(value: string){

    const myList = chosenCards2;
    const indexNumber = myList.findIndex((searchItem) => searchItem === value);
    console.log(indexNumber); 
    
    return indexNumber +1;
  }
  
  
  async function submitChosenCardsP1P2(){

    if (chosenCardsP1.length === 5 && chosenCards2.length === 5){
      
    
    let i=0;
    for(i=0; i < 5; i++){


    const stringList1: string[] = [chosenCardsP1[i]];
    console.log("check1P1: "+ chosenCards2[i])
    const chosenCards: string[] = stringList1.map((str: string) => str.slice(0, -1));
    console.log("check2P1: "+ chosenCards)
   
    const stringList: string[] = [chosenCards2[i]];
    console.log("check1P2: "+ chosenCards2[i])
    const chosenCardsP2: string[] = stringList.map((str: string) => str.slice(0, -1));
    console.log("check2P2: "+chosenCardsP2)
    
  
    try {
      const response = await fetch("/api/play/post", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ 
        chosenCards,
        chosenCardsP2
        }),
      });
    
      if (response.ok) {
        const gameState = await response.json();

        // console.log(gameState)
        setGameState(gameState);
        console.error(response.ok);

        removeAllItemsP1()
        removeAllItemsP2()
        if (gameState.robot1.y === 3 && gameState.robot1.x === 2){
          setWinnerMessage('Game over ' + gameState.robot1.name + ' has won!')
        }
        if (gameState.robot2.y === 3 && gameState.robot2.x === 2){
          setWinnerMessage('Game over ' + gameState.robot2.name + ' has won!')
        }

      } else {
        console.error(response.statusText);
      }
      } catch (error) {
        console.error(error);
      }
    }
    } else{
      console.log("Players should choose minimum 3 cards!")
      setErrorMessage("Players should choose minimum 3 cards!");
    }
  }

    return (
    <>
      <div className="container"  
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
      <div className="container_left">
        <div className="board"><GameBoard gameState={gameState} images={[]}/></div>
        <div className="winner_message"> {winnerMessage}</div>
      </div>
      <div className="container_right">
        <div className="cards_container">
          <div className="players">
            <span><h5 >{gameState.robot1.name} &nbsp;</h5></span><span><h6> a.k.a the lumberjack! &nbsp; vs</h6></span> <span><h5> &nbsp;{gameState.robot2.name} &nbsp;</h5> </span><span><h6>know as the incredible hulk!</h6></span>
          </div>
          <div className="cards_container1">
            <h1>Carddeck</h1>
            <div className="error_container">
              <p className="errorMessagePlay">{errorMessage}</p>
            </div>
            <div className="cards_player">
              <h3>Cards: {gameState.robot1.name}</h3>
            </div>
            <div className="cardsp1">
              {cardsP1.map((value, index) => (
                  <span className={`card ${chosenCardsP1.includes(value + index) ? 'selectedP1' : ''}`}>
                    {renderCardsP1(value, index)}
                    {chosenCardsP1.includes(value + index) && <span className="index-number">{checkIndexP1((value + index))}</span>}
                </span>
              ))}
            </div>
            {/* <div className="cardsp1">
                {cardsP1.map((value, index) => (
                  <span className="card" >
                  {renderCardsP1(value, index)}
                  </span>
                ))} 
            </div> */}
            <div className="cards_player">
              <h3>Cards: {gameState.robot2.name}</h3>
            </div>
            <div className="cardsp1">
              {cardsP2.map((value, index) => (
                <span className={`card ${chosenCards2.includes(value + index) ? 'selectedP2' : ''}`}>
                  {renderCardsP2(value, index)}
                  {chosenCards2.includes(value + index) && <span className="index-number">{checkIndexP2((value + index))}</span>}
                </span>
              ))}
            </div>
            <div className="button_container">
              <button className="button_remove" onClick={removeAllItemsP1}>Remove al items p1</button>
              <button className="button_remove" onClick={removeAllItemsP2}>Remove al items p2</button>
              <button className="button" onClick={submitChosenCardsP1P2}>Submit Programs</button>
            </div>
          </div>
          <div className="commentaar">
            <h1>Commentary</h1>
            <p className="commentary_message">{commentaryMessage}</p>
          </div>
        </div>
      </div>
    </div>
  </>
  );
}

export default PlayGame;
