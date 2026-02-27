package com.example.backend.project.repository;
import com.example.backend.project.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate,Long>{

}