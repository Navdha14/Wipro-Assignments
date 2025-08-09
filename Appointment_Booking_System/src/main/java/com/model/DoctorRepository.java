package com.model;

import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class DoctorRepository {

    private Map<String, List<LocalDate>> doctorSchedules;

    public DoctorRepository() {
        doctorSchedules = new HashMap<>();

        List<LocalDate> doc101Schedule = new ArrayList<>();
        doc101Schedule.add(LocalDate.of(2025, 4, 10));
        doc101Schedule.add(LocalDate.of(2025, 4, 12));
        doctorSchedules.put("DOC101", doc101Schedule);

    }

    public Map<String, List<LocalDate>> getDoctorSchedules() {
        return doctorSchedules;
    }

    public void setDoctorSchedules(Map<String, List<LocalDate>> doctorSchedules) {
        this.doctorSchedules = doctorSchedules;
    }

    public boolean isAvailable(String doctorId, LocalDate date) {
        List<LocalDate> availableDates = doctorSchedules.get(doctorId);
        return availableDates != null && availableDates.contains(date);
    }
}
