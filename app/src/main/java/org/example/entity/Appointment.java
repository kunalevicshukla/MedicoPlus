package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column
    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}
