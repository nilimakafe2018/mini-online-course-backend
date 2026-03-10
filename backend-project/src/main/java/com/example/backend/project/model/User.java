package com.example.backend.project.model;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.OneToOne;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String institution;

//    @Column(name="Certificate_Created")
//    private boolean certificateCreated;

    //required  by JPA, default constructor that is needed to create object from database rows
    public User() {}

    //constructor
    public User(String name, String email, String institution) {
        this.name=name;
        this.email=email;
        this.institution=institution;
        //this.certificateCreated=false;
    }

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    @JsonIgnore
    private Certificate certificate;

    //Getters and Setters
    public Long getId() {return id;}

    public String getName(){return name;}
    public void setName(String name){ this.name = name; }

    public String getEmail(){return email;}
    public void setEmail(String email){ this.email = email; }

    public String getInstitution(){return institution;}
    public void setInstitution(String institution){this.institution = institution;}

//    public boolean isCertificateCreated() {return certificateCreated;}
//    public void setCertificateCreated(boolean certificateCreated){
//        this.certificateCreated = certificateCreated;
//    }

    public Certificate getCertificate() {
        return certificate;
    }
    public void setCertificate(Certificate certificate){
        this.certificate=certificate;
    }
}