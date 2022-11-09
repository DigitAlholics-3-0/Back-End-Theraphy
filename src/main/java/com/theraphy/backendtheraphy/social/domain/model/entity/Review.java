package com.theraphy.backendtheraphy.social.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
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
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // physioId y patientId
    @NotBlank
    @NotNull
    @Size(max = 200)
    private String physiotherapist;

    @NotBlank
    @NotNull
    @Size(max = 200)
    private String reviewer;

    @NotNull
    private Integer stars;

    @NotBlank
    @NotNull
    @Size(max = 200)
    private String description;


    //relations

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "physiotherapist_id", nullable = false)
    @JsonIgnore
    private Physiotherapist doctor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnore
    private Patient patient;

}
