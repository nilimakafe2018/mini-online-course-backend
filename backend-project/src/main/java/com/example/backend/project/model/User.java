package com.example.backend.project.model;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User{

    //primary key for user table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String institution;

    //required  by JPA, default constructor that is needed to create object from database rows
    public User() {}

    //constructor used when creating new user
    public User(String name, String email, String institution) {
        this.name=name;
        this.email=email;
        this.institution=institution;
    }

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    @JsonIgnore
    private Certificate certificate;

    //Getter for user id and user name
    public Long getId() {
        return id;}

    public String getName(){
        return name;}

    //updating user name
    public void setName(String name){
        this.name = name; }

    public String getEmail(){
        return email;}

    public void setEmail(String email){
        this.email = email; }

    //getter for institution
    public String getInstitution(){
        return institution;}

    public void setInstitution(String institution){
        this.institution = institution;}

    //getter for certificate associate with user
    public Certificate getCertificate() {
        return certificate;
    }

    //updating certificate associated with user
    public void setCertificate(Certificate certificate){
        this.certificate=certificate;
    }
}