package com.theraphy.backendtheraphy.social.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewResource {

    @NotBlank
    @NotNull
    @Size(max = 200)
    private String physiotherapist;

    @NotBlank
    @NotNull
    @Size(max = 200)
    private String reviewer;

    @NotNull
    private Integer stars;

    @NotBlank
    @NotNull
    @Size(max = 200)
    private String description;
}