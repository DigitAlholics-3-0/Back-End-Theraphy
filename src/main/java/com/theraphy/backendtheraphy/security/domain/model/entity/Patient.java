package com.theraphy.backendtheraphy.security.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


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
}
