package com.roborally.api.models;

import roborally.domain.Robot;
import roborally.domain.User;

public class UserDTO
{

    private String name;
    private String email;
    private String password;
    
    public String getName() {
        return name;
    }   

    public void setname(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

     public String getPassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }

        public UserDTO (User input){
        setname(input.getName());
        setemail(input.getEmail());
        setpassword(input.getPassword());
    }

  
}