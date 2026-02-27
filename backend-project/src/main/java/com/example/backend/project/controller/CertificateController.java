package com.example.backend.project.controller;
import java.time.LocalDate;
import com.example.backend.project.model.Certificate;
import com.example.backend.project.model.User;
import com.example.backend.project.repository.CertificateRepository;
import com.example.backend.project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certificates")
@CrossOrigin

public class CertificateController{

    private final CertificateRepository certificateRepository;
    private final UserRepository userRepository;

    public CertificateController(CertificateRepository certificateRepository, UserRepository userRepository){
        this.certificateRepository=certificateRepository;
        this.userRepository=userRepository;
    }

    //create certificate when the course is complete
    @PostMapping("/user/{userId}")
    public Certificate createCertificate(@PathVariable Long userId){
        //fetching the user
        User user= userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Sorry, user not found!"));

        //checking if the user already has a certificate
        Certificate existingCertificate= certificateRepository.findByUser_Id(userId).orElse(null);
        if(existingCertificate != null){
            return existingCertificate;
        }

        //creating a new certificate for the new user
        Certificate certificate= new Certificate();
        certificate.setUser(user);
        certificate.setIssueDate(LocalDate.now());

        Certificate savedCertificate=certificateRepository.save(certificate);

        //updating the user's certificate flag and link the certificate to the user
        user.setCertificateCreated(true);
        user.setCertificate(savedCertificate);
        userRepository.save(user);

        return savedCertificate;

    }

    //read certificate for a user
    @GetMapping("/user/{userId}")
    public Certificate getCertificate(@PathVariable Long userId){
        return certificateRepository.findByUser_Id(userId).orElseThrow(() -> new RuntimeException("Sorry, certificate not found!"));
    }

}