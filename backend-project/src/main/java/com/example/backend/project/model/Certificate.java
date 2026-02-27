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

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    //default constructor required by JPA
    public Certificate() {}


    public Certificate(LocalDate issueDate,User user) {
        this.issueDate=issueDate;
        this.user=user;
    }

    public Long getId(){
        return id;
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

    //method to get the user name for the certificate automatically
    @Transient
    public String getUserName(){
        return user != null ? user.getName() : null;
    }

}
