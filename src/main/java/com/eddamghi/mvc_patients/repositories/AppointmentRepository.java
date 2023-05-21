package com.eddamghi.mvc_patients.repositories;

import com.eddamghi.mvc_patients.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
