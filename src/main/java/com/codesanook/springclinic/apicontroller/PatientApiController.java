package com.codesanook.springclinic.apicontroller;

import com.codesanook.springclinic.model.Patient;
import com.codesanook.springclinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/patients")
@Transactional(readOnly = false, rollbackFor = Exception.class,
        isolation = Isolation.READ_COMMITTED)
public class PatientApiController {

    private PatientRepository patientRepository;

    @Autowired
    public PatientApiController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public int addPatient(@RequestBody Patient patient) {
        patientRepository.add(patient);
        return patient.getHospitalNumber();
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Patient> getAllPatients() {
        return patientRepository.getAll();
    }


    @RequestMapping(value = "/{hospitalNumber}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable int hospitalNumber) {
        return patientRepository.get(hospitalNumber);
    }


    @RequestMapping(value = "/{hospitalNumber}", method = RequestMethod.PUT)
    public void updatePatient(@PathVariable int hospitalNumber,
                              @RequestBody Patient patientRequest) {
        Patient patient = patientRepository.get(hospitalNumber);
        patient.setFirstName(patientRequest.getFirstName());
        patient.setLastName(patientRequest.getLastName());
    }


    @RequestMapping(value = "/{hospitalNumber}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removePatient(@PathVariable int hospitalNumber) {
        Patient patient = patientRepository.get(hospitalNumber);
        patientRepository.remove(patient);
    }
}
