package org.example;

import org.example.entity.Insurance;
import org.example.entity.Patient;
import org.example.repository.InsuranceRepository;
import org.example.repository.PatientRepository;
import org.example.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;
    @Autowired
    private InsuranceService insuranceService;
    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder().policyNumber("1234").provider("HDFC")
                .validUntil(LocalDate.of(2026,1,1)).build();
        Patient patient = insuranceService.addInsuranceToPatient(1L,insurance);
        System.out.println(patient);
    }
}
