package org.example.controller;

import org.example.entity.Appointment;
import org.example.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(
            @RequestBody Appointment appointment,
            @RequestParam Long patientId,
            @RequestParam Long doctorId) {
        Appointment createdAppointment = appointmentService.createNewAppointment(appointment, patientId, doctorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
    }

    @PutMapping("/{appointmentId}/reassign")
    public ResponseEntity<Appointment> reassignAppointment(
            @PathVariable Long appointmentId,
            @RequestParam Long doctorId) {
        Appointment updatedAppointment = appointmentService.reassignAppointmentToAnotherDoctor(appointmentId, doctorId);
        return ResponseEntity.ok(updatedAppointment);
    }
}
