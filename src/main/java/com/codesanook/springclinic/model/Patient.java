package com.codesanook.springclinic.model;
import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalNumber;

    private String firstName;
    private String lastName;

    public int getHospitalNumber() {
        return hospitalNumber;
    }

    public void setHospitalNo(int hospitalNumber) {
        this.hospitalNumber = hospitalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
