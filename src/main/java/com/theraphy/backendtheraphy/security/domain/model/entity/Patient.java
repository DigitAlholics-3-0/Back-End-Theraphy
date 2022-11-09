package com.theraphy.backendtheraphy.security.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import com.theraphy.backendtheraphy.social.domain.model.entity.Review;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "last_name")
    private String lastName;

    private int age;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "photo_url")
    private String photoUrl;

    @NotNull
    @NotBlank
    @Column(name = "birthday_date")
    private String birthdayDate;



    //relation

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, mappedBy = "patient")
    private Set<Review> reviews = new HashSet<>();

    public Patient addReview(String physiotherapist,
                             String reviewer,
                             Integer stars,
                             String description,
                             Physiotherapist doctor) {
        // Initialize if null
        if(reviews == null) {
            reviews = new HashSet<>();
        }

        // Add Criterion to Skill
        reviews.add(new Review()
                        .withDescription(description)
                        .withReviewer(reviewer)
                        .withStars(stars)
                        .withPhysiotherapist(physiotherapist)
                        .withDoctor(doctor)
                        .withPatient(this));
        return this;
    }
}
