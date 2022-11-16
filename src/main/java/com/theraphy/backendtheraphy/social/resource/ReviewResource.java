package com.theraphy.backendtheraphy.social.resource;

import com.theraphy.backendtheraphy.profile.resource.PatientResource;
import com.theraphy.backendtheraphy.profile.resource.PhysiotherapistResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResource {
    private Long id;
    private String description;
    private Long stars;
    private PatientResource patient;
    private PhysiotherapistResource physiotherapist;
}
