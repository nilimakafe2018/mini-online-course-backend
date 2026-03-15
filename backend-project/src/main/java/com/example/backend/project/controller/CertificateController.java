package com.example.backend.project.controller;
import com.example.backend.project.model.Certificate;
import com.example.backend.project.model.User;
import com.example.backend.project.repository.CertificateRepository;
import com.example.backend.project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

//rest controller to handle http requests
@RestController
@RequestMapping("/api/certificates")
@CrossOrigin
public class CertificateController {

    private final CertificateRepository certificateRepository;   //repository for certificate entity
    private final UserRepository userRepository;                 //repository for user entity

    //constructor for dependency injection
    public CertificateController(CertificateRepository certificateRepository, UserRepository userRepository) {
        this.certificateRepository = certificateRepository;
        this.userRepository = userRepository;
    }

    //endpoints to create certificate for user
    @PostMapping("/{userId}")
    public ResponseEntity<?> createCertificate(
            @PathVariable Long userId,
            @RequestParam String color
    ) {
        //finding user in the bd using the userId, if user not found, will throw exception
        User user = userRepository.findById(userId).orElseThrow();

        //prevent duplicate certificate create for same user
        //checking if certificate already exists for the user
        if (certificateRepository.findByUserId(userId).isPresent()) {
            return ResponseEntity.badRequest()
                    .body("Certificate already exists for this user");
        }

        Certificate certificate = new Certificate(user, color); //creating new certificate object and saving in bd
        certificateRepository.save(certificate);

        return ResponseEntity.ok(certificate);
    }

    //endpoint to get certificate by user id
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCertificateByUser(@PathVariable Long userId) {
        return certificateRepository.findByUserId(userId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //endpoint to update certificate color
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateCertificateColor(
            @PathVariable Long userId,
            @RequestParam String color
    ) {
        //finding existing certificate for user, if not found, will throw exception
        Certificate certificate = certificateRepository.findByUserId(userId).orElseThrow();
        certificate.setCertificateColor(color);   //updating certificate color
        certificateRepository.save(certificate);  //saving updated certificate in db
        return ResponseEntity.ok(certificate);
    }
}