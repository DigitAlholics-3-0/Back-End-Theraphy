package com.theraphy.backendtheraphy.treatments.domain.model.entity;


import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "treatments_by_patient")
public class TreatmentByPatient extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private Long treatmentId;

    @NotBlank
    @NotNull
    private Long patientId;

    @NotBlank
    @NotNull
    @Size(max = 50)
    @Column(unique = true)
    private String title;

    @NotBlank
    @NotNull
    @Size(max = 200)
    private String description;

    @Column(name = "sessions_quantity")
    private int sessionsQuantity;

    @NotBlank
    @NotNull
    private Long physiotherapistId;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "photo_url")
    private String photoUrl;

    @NotBlank
    @NotNull
    private String videoSessions;

    @NotBlank
    @NotNull
    @Size(max = 60)
    private String registrationDate;

    @NotBlank
    @NotNull
    private Integer progress;

}