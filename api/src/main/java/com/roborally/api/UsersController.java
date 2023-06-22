package com.roborally.api;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.roborally.api.models.UserInputDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import roborally.database.UserRepository;
import roborally.domain.User;


@EnableJpaRepositories(basePackages = {"roborally.database.*"})
@Controller // This means that this class is a Controller
@RequestMapping(path = "/api/database") // This means URL's start with /demo (after Application path)
public class UsersController {
 
  @Autowired // This means to get the bean called userRepository
  private UserRepository userRepository;

  @PostMapping(path = "/register") // Map ONLY POST Requests
  public @ResponseBody String addNewUser(
      @RequestBody UserInputDTO input) {
        
    User user = new User(input.getName(), input.getEmail(), input.getPassword());
    user.setName(input.getName());
    user.setEmail(input.getEmail());
    user.setPassword(input.getPassword());
    userRepository.save(user);
    return "Saved";
    }

}

