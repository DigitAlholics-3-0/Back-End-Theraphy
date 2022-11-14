package com.theraphy.backendtheraphy.profiles.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateMedicalHistoryResource {

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String patientName;

    @NotNull
    private Double height;

    @NotNull
    private Double weight;

    @NotNull
    private Double bodyMass;

}
