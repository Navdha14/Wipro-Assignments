package com.hms.doctor_service.service;

import com.hms.doctor_service.model.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    Doctor updateDoctor(Long id, Doctor doctor);
    void deleteDoctor(Long id);
}
