package com.theraphy.backendtheraphy.profiles.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateMedicalHistoryResource {

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
