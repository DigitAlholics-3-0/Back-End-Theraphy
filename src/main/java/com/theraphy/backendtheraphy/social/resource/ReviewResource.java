package com.theraphy.backendtheraphy.social.resource;

import com.theraphy.backendtheraphy.security.resource.PatientResource;
import com.theraphy.backendtheraphy.security.resource.PhysiotherapistResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResource {

    private Long id;

    private String physiotherapist;

    private String reviewer;

    private Integer stars;

    private String description;

    //relations

    private PhysiotherapistResource doctor;

    private PatientResource patient;
}
