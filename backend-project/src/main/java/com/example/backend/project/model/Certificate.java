package com.example.backend.project.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="certificates")

public class Certificate {

    //primary key for certificate table
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private LocalDate issueDate;

    private String certificateColor;

    @OneToOne
    @JoinColumn(name="user_id", unique=true)
    private User user;

    public Certificate() {}

    //constructor used when creating new certificate
    public Certificate(User user, String certificateColor) {
        this.user=user;
        this.certificateColor = certificateColor;
        this.issueDate = LocalDate.now();
    }

    public String getCertificateColor(){
        return certificateColor;
    }

    //getters for certificate id, issue date
    public Long getId(){
        return id;
    }

    public LocalDate getIssueDate(){
        return issueDate;
    }

    //updating certificate color
    public void setCertificateColor(String certificateColor){
        this.certificateColor=certificateColor;
    }

    //returning the user associated with this certificate
    public User getUser(){
        return user;
    }

    //updating the user associated with the certificate
    public void setUser(User user){
        this.user=user;
    }
}
