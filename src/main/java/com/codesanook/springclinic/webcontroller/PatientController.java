package com.codesanook.springclinic.webcontroller;

import com.codesanook.springclinic.model.Patient;
import com.codesanook.springclinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/patient")
@Transactional(readOnly = false, rollbackFor = Exception.class,
        isolation = Isolation.READ_COMMITTED)
public class PatientController {

    private PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "patient/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Patient patient) {
        patientRepository.add(patient);
        return "patient/patient-created";
    }

}

