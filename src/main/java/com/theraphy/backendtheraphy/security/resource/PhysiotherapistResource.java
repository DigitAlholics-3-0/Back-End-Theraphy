package com.theraphy.backendtheraphy.security.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PhysiotherapistResource {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String location;
    private String photoUrl;
    private String birthdayDate;
}