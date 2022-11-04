package com.theraphy.backendtheraphy.security.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PatientResource {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String photoUrl;
    private String birthdayDate;
}