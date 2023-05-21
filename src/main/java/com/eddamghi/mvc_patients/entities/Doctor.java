package com.eddamghi.mvc_patients.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String speciality;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Collection<Consultation> consultations;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Collection<Appointment> appointments;
}
