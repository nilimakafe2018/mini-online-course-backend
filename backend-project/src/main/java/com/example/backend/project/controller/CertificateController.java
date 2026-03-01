package com.example.backend.project.controller;

import com.example.backend.project.model.Certificate;
import com.example.backend.project.model.User;
import com.example.backend.project.repository.CertificateRepository;
import com.example.backend.project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/certificates")
@CrossOrigin
public class CertificateController {

    private final CertificateRepository certificateRepository;
    private final UserRepository userRepository;

    public CertificateController(CertificateRepository certificateRepository, UserRepository userRepository) {
        this.certificateRepository = certificateRepository;
        this.userRepository = userRepository;
    }

    // create certificate for user
    @PostMapping("/{userId}")
    public ResponseEntity<?> createCertificate(
            @PathVariable Long userId,
            @RequestParam String color
    ) {
        User user = userRepository.findById(userId).orElseThrow();

        //prevent duplicate certificate
        if (user.isCertificateCreated()) {
            return ResponseEntity
                    .badRequest()
                    .body("Certificate already exists for this user");
        }

        Certificate certificate = new Certificate(user, color);
        user.setCertificateCreated(true);
        user.setCertificate(certificate);

        certificateRepository.save(certificate);

        return ResponseEntity.ok(certificate);
    }

}