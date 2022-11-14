package com.theraphy.backendtheraphy.profiles.domain.model.entity;

import com.theraphy.backendtheraphy.security.domain.model.entity.Role;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medical_histories")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotNull
    @NotBlank
    @Size(max = 200)
    @Column(name = "patient_name")
    private String patientName;

    @NotNull
    private Double height;

    @NotNull
    private Double weight;

    @NotNull
    @Column(name = "body_mass")
    private Double bodyMass;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patient_allergies",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "allergy_id"))
    private Set<Allergy> allergies = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patient_pathological_histories",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "pathological_history_id"))
    private Set<PathologicalHistory> pathologicalHistories = new HashSet<>();



}
