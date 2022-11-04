package com.theraphy.backendtheraphy.appointments.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResource {
    private Long id;
    private String scheduledDate;
    private String topic;
    private String diagnosis;
    private String done;
}