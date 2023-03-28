package com.eddamghi.mvc_patients.repositories;

import com.eddamghi.mvc_patients.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByLastNameContains(String keyword, Pageable pageable);
    Page<Patient> findByVaccinated(boolean vaccinated, Pageable pageable);
    @Query("select p from Patient p where p.score > 10 and p.vaccinated = true")
    List<Patient> searchPatients(@Param ("score") int score, @Param ("vaccinated") boolean vaccinated);

}
