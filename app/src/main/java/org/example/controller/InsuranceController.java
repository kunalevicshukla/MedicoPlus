package org.example.controller;

import org.example.entity.Insurance;
import org.example.entity.Patient;
import org.example.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/patient/{patientId}")
    public ResponseEntity<Patient> addInsuranceToPatient(
            @PathVariable Long patientId,
            @RequestBody Insurance insurance) {
        Patient patient = insuranceService.addInsuranceToPatient(patientId, insurance);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }
}
