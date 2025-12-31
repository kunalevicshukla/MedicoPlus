package org.example.service;

import org.example.entity.Insurance;
import org.example.entity.Patient;
import org.example.repository.InsuranceRepository;
import org.example.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    public InsuranceService(InsuranceRepository insuranceRepository, PatientRepository patientRepository) {
        this.insuranceRepository = insuranceRepository;
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Patient addInsuranceToPatient(Long patientId, Insurance insurance) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));

        insurance.setPatient(patient);
        Insurance savedInsurance = insuranceRepository.save(insurance);

        patient.setInsurance(savedInsurance);
        patientRepository.save(patient);

        return patient;
    }
}
