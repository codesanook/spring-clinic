package com.codesanook.springclinic.repository;

import com.codesanook.springclinic.model.Patient;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PatientRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Patient get(int hospitalNumber) {
        Patient patient = entityManager.getReference(Patient.class, hospitalNumber);
        return patient;
    }


    public List<Patient> getAll() {
        Query query = entityManager.createQuery("select p from Patient p",
                Patient.class);
        return query.getResultList();
    }


    public void add(Patient patient) {
        entityManager.persist(patient);
    }


    public void remove(Patient patient) {
        entityManager.remove(patient);
    }

}
