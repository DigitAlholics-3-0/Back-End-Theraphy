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
public class CreatePathologicalHistoryResource {
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String name;

}
