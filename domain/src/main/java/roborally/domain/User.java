package roborally.domain;

import jakarta.persistence.*;

@Entity
@Table(name="users_table")
public class User
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;
    
    @Column(nullable=false)
    private String password;

   
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

     public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
      public User(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}