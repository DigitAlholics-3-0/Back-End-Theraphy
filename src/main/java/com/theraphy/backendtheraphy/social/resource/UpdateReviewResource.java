package com.theraphy.backendtheraphy.social.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateReviewResource {

    private Long id;

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
