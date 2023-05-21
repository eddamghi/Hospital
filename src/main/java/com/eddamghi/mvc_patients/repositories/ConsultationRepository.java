package com.eddamghi.mvc_patients.repositories;

import com.eddamghi.mvc_patients.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
