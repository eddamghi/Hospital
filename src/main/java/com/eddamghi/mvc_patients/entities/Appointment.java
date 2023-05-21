package com.eddamghi.mvc_patients.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "appointments")
public class Appointment  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date date;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    @OneToOne(mappedBy = "appointment")
    private Consultation consultation;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
}
