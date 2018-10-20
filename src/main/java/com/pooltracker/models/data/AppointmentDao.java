package com.pooltracker.models.data;

import com.pooltracker.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface AppointmentDao extends CrudRepository<Appointment, Integer> {

}
