package com.roborally.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.roborally.api.models.RoborallyDTO;
import com.roborally.api.models.Robot2MovesDTO;
import com.roborally.api.models.RobotDTO;
import com.roborally.api.models.RobotMovesDTO;
// import com.roborally.api.models.RobotMovesDTO;
import com.roborally.api.models.BoardDTO;
import com.roborally.api.models.CardDeckDTO;
import com.roborally.api.models.PlayInputDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import roborally.domain.Board;
import roborally.domain.CardDeck;
import roborally.domain.Robot;


@Configuration
@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/play") // This means URL's start with /demo (after Application path)
public class PlayController {

  @PostMapping(path = "/post")
  public ResponseEntity<RoborallyDTO> post(HttpServletRequest request, HttpSession session, @RequestBody PlayInputDTO move) {
    Robot robot = (Robot) session.getAttribute("roborally");
    Board bord = (Board) session.getAttribute("bord");
    CardDeck cards = (CardDeck) session.getAttribute("cards");
    // ArrayList<Robot> robot1moves = (ArrayList<Robot>) session.getAttribute("moves");

    ArrayList<RobotDTO> robot1moves = new ArrayList<>();
     ArrayList<RobotDTO> robot2moves = new ArrayList<>();


    //player1 moves
    for (String item : move.getChosenCards()) {
      cards.chosenCardsP1( item);
      
      switch (item) {
        case "moveone":
        robot.MoveOne();
        robot1moves.add(new RobotDTO(robot));
        System.out.println("robot1 1 moves " + robot1moves);
            break;
        case "movetwo":
        robot.MoveOne();
         robot1moves.add(new RobotDTO(robot));
        System.out.println("robot1 2 moves " + robot1moves);
        robot.MoveOne();
         robot1moves.add(new RobotDTO(robot));
        System.out.println("robot1 2.1 moves " + robot1moves);
            break;
        case "movethree":
        robot.MoveOne();
         robot1moves.add(new RobotDTO(robot));
        System.out.println("robot1 3.1 moves " + robot1moves);
        robot.MoveOne();
         robot1moves.add(new RobotDTO(robot));
        System.out.println("robot1 3.2 moves " + robot1moves);
        robot.MoveOne();
         robot1moves.add(new RobotDTO(robot));
        System.out.println("robot1 3.3 moves " + robot1moves);
            break;
        case "turnleft":
        robot.TurnLeft();
         robot1moves.add(new RobotDTO(robot));
        System.out.println("robot1 left moves " + robot1moves);
            break;
        case "turnright":
           robot.TurnRight();
            robot1moves.add(new RobotDTO(robot));
           System.out.println("robot1 right moves " + robot1moves);
           break;
        case "turnaround":
           robot.TurnAround();
            robot1moves.add(new RobotDTO(robot));
           System.out.println("robot1 around moves " + robot1moves);
          break;
      }
    }

    //player2 moves
    for (String item2 : move.getChosenCardsP2()) {
      cards.chosenCardsP2(item2); 

      switch (item2) {
        case "moveone":
        robot.getTegenspeler().MoveOne();
        robot2moves.add(new RobotDTO(robot));
        System.out.println("robot2 1 moves " + robot2moves);
            break;
        case "movetwo":
        robot.getTegenspeler().MoveOne();
        robot2moves.add(new RobotDTO(robot));
        System.out.println("robot2 2 moves " + robot2moves);
        robot.getTegenspeler().MoveOne();
        robot2moves.add(new RobotDTO(robot));
        System.out.println("robot2 2.1 moves " + robot2moves);
            break;
        case "movethree":
        robot.getTegenspeler().MoveOne();
        robot2moves.add(new RobotDTO(robot));
        System.out.println("robot2 3.1 moves " + robot2moves);
        robot.getTegenspeler().MoveOne();
        robot2moves.add(new RobotDTO(robot));
        System.out.println("robot2 3.2 moves " + robot2moves);
        robot.getTegenspeler().MoveOne();
        robot2moves.add(new RobotDTO(robot));
        System.out.println("robot2 3.3 moves " + robot2moves);
            break;
        case "turnleft":
        robot.getTegenspeler().TurnLeft();
        robot2moves.add(new RobotDTO(robot));
        System.out.println("robot2 left moves " + robot2moves);
            break;
        case "turnright":
        robot.getTegenspeler().TurnRight();
        robot2moves.add(new RobotDTO(robot));
        System.out.println("robot2 right moves " + robot2moves);
           break;
        case "turnaround":
        robot.getTegenspeler().TurnAround();
        robot2moves.add(new RobotDTO(robot));
        System.out.println("robot2 around moves " + robot2moves);
          break;
      }
    }

    BoardDTO bordDTO = new BoardDTO(bord);

    CardDeckDTO cardsDTO = new CardDeckDTO(cards, cards);

    RobotDTO robot1 = new RobotDTO(robot);

    RobotMovesDTO robot1movess = new RobotMovesDTO(robot1moves);

    RobotDTO robot2 = new RobotDTO(robot.getTegenspeler());

    Robot2MovesDTO robot2movess = new Robot2MovesDTO(robot2moves);

    RoborallyDTO dto = new RoborallyDTO(bordDTO, cardsDTO, robot1, robot2, robot1movess, robot2movess);
   
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }
}