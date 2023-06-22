package com.roborally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

import roborally.database.UserRepository;
import roborally.domain.User;

//import roborally.database.UserRepository;
// import roborally.domain.User;
// import roborally.database.RandomRepository;
// import roborally.domain.Test.RandomNumber;

@EnableJpaRepositories(basePackages = {"roborally.database"})
@EntityScan("roborally.domain")

@SpringBootApplication
public class App
    implements CommandLineRunner {
    @Autowired UserRepository userRepository;
    // @Autowired RandomRepository randomRepository;
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception
    {
        // Inserting the data in the mysql table.
        User first = new User("name1", "Piet1", "piet@gmail.com1");
        userRepository.save(first);
    }

    @GetMapping("/hello")
	    public String index() {
		return "Hello!";
	}
}