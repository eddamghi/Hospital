package com.eddamghi.mvc_patients.controllers;

import com.eddamghi.mvc_patients.entities.Doctor;
import com.eddamghi.mvc_patients.entities.Patient;
import com.eddamghi.mvc_patients.repositories.DoctorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DoctorController {
    DoctorRepository doctorRepository;
    @GetMapping("/doctors")
    public String doctors(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5")int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Doctor> doctors = doctorRepository.findByLastNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("doctors", doctors.getContent());
        model.addAttribute("pages", new int[doctors.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "doctors";
    }
}
