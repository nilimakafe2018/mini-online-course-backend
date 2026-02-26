package com.example.backend.project.model;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Column(name="Certificate_Created")
    private boolean certificateCreated;

    //required  by JPA
    public User() {}

    //constructor
    public User(String name, String email, String password){
        this.name=name;
        this.email=email;
        this.password=password;
        this.certificateCreated=false;
    }

    //Getters and Setters
    public Long getId() {return id;}

    public String getName(){return name;}
    public void SetName(String name){this.name=name;}

    public String getEmail(){return email;}
    public void SetEmail(String email){this.email=email;}

    public String getPassword(){return password;}
    public void SetPassword(String password){this.password=password;}

    public boolean isCertificateCreated() {return certificateCreated;}
    public void setCertificateCreated(boolean certificateCreated){
        this.certificateCreated = certificateCreated;
    }
}