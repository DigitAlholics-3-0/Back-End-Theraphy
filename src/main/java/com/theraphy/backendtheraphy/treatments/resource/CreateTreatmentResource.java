package com.theraphy.backendtheraphy.treatments.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTreatmentResource {

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String title;

    @NotBlank
    @NotNull
    @Size(max = 200)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String photoUrl;

    private int sessionsQuantity;
}