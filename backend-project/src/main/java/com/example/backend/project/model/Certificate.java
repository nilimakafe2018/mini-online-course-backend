package com.example.backend.project.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="certificates")

public class Certificate {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private LocalDate issueDate;

    private String certificateColor;

    @OneToOne
    @JoinColumn(name="user_id", unique=true)
    private User user;

    //default constructor required by JPA
    public Certificate() {}


    public Certificate(User user, String certificateColor) {
        this.user=user;
        this.certificateColor = certificateColor;
        this.issueDate = LocalDate.now();
    }

    //getters and setters
    public Long getId(){
        return id;
    }

    public LocalDate getIssueDate(){
        return issueDate;
    }

    public void setCertificateColor(String certificateColor){
        this.certificateColor=certificateColor;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }
}
