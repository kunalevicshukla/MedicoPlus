package org.example;

import org.example.entity.Patient;
import org.example.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    public PatientRepository patientRepository;

    @Test
    public void testPatientRepo(){
        List<Patient> patients = patientRepository.findAll();
        System.out.println("list of patients is"+patients);
    }
}
