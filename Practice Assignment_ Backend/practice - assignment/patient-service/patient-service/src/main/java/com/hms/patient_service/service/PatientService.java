package com.hms.patient_service.service;

import com.hms.patient_service.model.Patient;
import com.hms.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setFirstName(updatedPatient.getFirstName());
                    patient.setLastName(updatedPatient.getLastName());
                    patient.setGender(updatedPatient.getGender());
                    patient.setDateOfBirth(updatedPatient.getDateOfBirth());
                    patient.setContactNumber(updatedPatient.getContactNumber());
                    patient.setEmail(updatedPatient.getEmail());
                    patient.setAddress(updatedPatient.getAddress());
                    patient.setInsuranceProvider(updatedPatient.getInsuranceProvider());
                    patient.setInsuranceNumber(updatedPatient.getInsuranceNumber());
                    return patientRepository.save(patient);
                })
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
