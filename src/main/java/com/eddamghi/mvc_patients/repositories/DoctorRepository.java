package com.eddamghi.mvc_patients.repositories;

import com.eddamghi.mvc_patients.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findByLastNameContains(String keyword, Pageable pageable);

    Doctor findByFirstName(String firstName);
}
