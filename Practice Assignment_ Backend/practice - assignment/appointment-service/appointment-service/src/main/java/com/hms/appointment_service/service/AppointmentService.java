package com.hms.appointment_service.service;

import com.hms.appointment_service.model.Appointment;
import com.hms.appointment_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus("BOOKED");
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment rescheduleAppointment(Long id, String newDate, String newTime) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment != null) {
            appointment.setAppointmentDate(newDate);
            appointment.setAppointmentTime(newTime);
            appointment.setStatus("RESCHEDULED");
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    public String cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment != null) {
            appointment.setStatus("CANCELLED");
            appointmentRepository.save(appointment);
            return "Appointment cancelled successfully!";
        }
        return "Appointment not found!";
    }
}
