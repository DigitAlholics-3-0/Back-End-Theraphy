package com.theraphy.backendtheraphy.security.resource;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientResource {

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String lastName;

    @Min(18)
    private int age;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String photoUrl;

    @NotNull
    @NotBlank
    private String birthdayDate;
}