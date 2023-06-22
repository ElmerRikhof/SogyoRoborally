package com.roborally.api;

import roborally.domain.Board;
import roborally.domain.CardDeck;
import roborally.domain.Robot;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.roborally.api.models.BoardDTO;
import com.roborally.api.models.CardDeckDTO;
import com.roborally.api.models.RoborallyDTO;
import com.roborally.api.models.Robot2MovesDTO;
import com.roborally.api.models.RobotDTO;
import com.roborally.api.models.RobotInputDTO;
import com.roborally.api.models.RobotMovesDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Configuration
@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/start") // This means URL's start with /demo (after Application path)
public class StartGameController {

  @PostMapping(path = "/post")
  public ResponseEntity<RoborallyDTO> post(HttpServletRequest request, HttpSession session, @RequestBody RobotInputDTO players) {
   
    // String roborally = request.getParameter("roborally");
   
    Board bord = new Board();

    CardDeck cards = new CardDeck();

    Robot robot = new Robot(players.getNameRobot1(), players.getNameRobot2(), bord, null);

    ArrayList<RobotDTO> robot1moves = new ArrayList<>();
    ArrayList<RobotDTO> robot2moves = new ArrayList<>();

    session.setAttribute("roborally", robot);
    session.setAttribute("bord", bord);
    session.setAttribute("cards", cards);
    // session.setAttribute("Moves", robot1moves);
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
