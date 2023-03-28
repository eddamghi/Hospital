package com.eddamghi.mvc_patients;

import com.eddamghi.mvc_patients.entities.Patient;
import com.eddamghi.mvc_patients.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MvcPatientsApplication {
	public static void main(String[] args) {
		SpringApplication.run(MvcPatientsApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
		return args -> {
//			patientRepository.save(new Patient(null, "EDDAMGHI", "Zineb", new Date(), false, 11));
//			patientRepository.save(new Patient(null, "BEN SADIK", "Youssef", new Date(), false, 12));
//			patientRepository.save(new Patient(null, "ET-TOUADI", "Yasmine", new Date(), true, 11));
//			patientRepository.save(new Patient(null, "LAAROUSSI", "Abir", new Date(), true, 14));
//			patientRepository.findAll().forEach(patient -> {
//				System.out.println(patient.getFirstName());
//			});
		};

	}
}
