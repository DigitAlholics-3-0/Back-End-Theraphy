package com.theraphy.backend.treatments.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateVideoSessionResource {

    @NotNull
    @NotBlank
    @Size(max = 120)
    private String link;

}
