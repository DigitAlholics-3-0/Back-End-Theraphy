package com.theraphy.backend.treatments.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateVideoSessionResource {

    @NotNull
    @NotBlank
    @Size(max = 120)
    private String link;

}