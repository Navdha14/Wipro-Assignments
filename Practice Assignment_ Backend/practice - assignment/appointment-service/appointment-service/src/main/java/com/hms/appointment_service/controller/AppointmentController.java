package com.hms.appointment_service.controller;

import com.hms.appointment_service.model.Appointment;
import com.hms.appointment_service.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Book Appointment
    @PostMapping
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    // Get Appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    // Get All Appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Reschedule Appointment
    @PutMapping("/{id}/reschedule")
    public Appointment rescheduleAppointment(
            @PathVariable Long id,
            @RequestParam String newDate,
            @RequestParam String newTime) {
        return appointmentService.rescheduleAppointment(id, newDate, newTime);
    }

    // Cancel Appointment
    @PutMapping("/{id}/cancel")
    public String cancelAppointment(@PathVariable Long id) {
        return appointmentService.cancelAppointment(id);
    }
}
