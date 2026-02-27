package com.example.backend.project.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="certificates")

public class Certificate {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private LocalDate issueDate;

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Certificate(String userName,LocalDate issueDate,User user) {
        this.userName=userName;
        this.issueDate=issueDate;
        this.user=user;
    }

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public LocalDate getIssueDate(){
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate){
        this.issueDate=issueDate;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }

}
