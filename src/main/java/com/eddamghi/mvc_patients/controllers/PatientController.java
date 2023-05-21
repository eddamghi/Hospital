package com.eddamghi.mvc_patients.controllers;

import com.eddamghi.mvc_patients.entities.Patient;
import com.eddamghi.mvc_patients.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@Controller
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/patients/index")
    public String patients(Model model,
                           @RequestParam(name = "page", defaultValue = "1") int page,
                           @RequestParam(name = "size", defaultValue = "5")int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword,
                           @RequestParam(name = "vaccinated", defaultValue = "true") boolean vaccinated) {
        Page<Patient> patients = patientRepository.findByLastNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }
    @GetMapping("/patients/admin/delete")
    public String deletePatient(Long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/patients/admin/edit")
    public String editPatient(@RequestParam(name = "id") Long id, Model model){
        Patient patient=patientRepository.findById(id).get();
        model.addAttribute("patient",patient);
        return "editPatient";
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
    @GetMapping("/patients/admin/formPatients")
    public String formPatients(Model model){
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }
    @GetMapping("/patients/admin/save")
    public String savePatient(Patient patient){
        patientRepository.save(patient);
        return "formPatients";
    }
}
