package com.theraphy.backendtheraphy.appointments.domain.persistence;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    Appointment findByTopic(String topic);
}