package com.theraphy.backendtheraphy.profiles.resource;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateEducationResource {

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String specialization;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String physiotherapistName;
}
