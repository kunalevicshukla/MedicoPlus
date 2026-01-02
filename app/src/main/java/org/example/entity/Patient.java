package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"insurance", "appointments"})
@Table(
        indexes = {
                @Index(
                        name = "dob_idx",
                        columnList = "dob"
                )
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dob;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private BloodGroup blood_Group;
    @OneToOne
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Appointment> appointments;
}

enum  Gender {
    MALE,
    FEMALE
}

enum BloodGroup {
    A_POSITIVE,
    A_NEGATIVE,
    B_POSITIVE,
    B_NEGATIVE,
    O_POSITIVE,
    O_NEGATIVE,
    AB_POSITIVE,
    AB_NEGATIVE,
}