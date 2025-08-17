package com.hms.medical_records_service.service;

import com.hms.medical_records_service.model.MedicalRecord;
import com.hms.medical_records_service.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository repository;

    public MedicalRecord saveRecord(MedicalRecord record) {
        return repository.save(record);
    }

    public MedicalRecord getRecordById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<MedicalRecord> getRecordsByPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    public List<MedicalRecord> getAllRecords() {
        return repository.findAll();
    }

    public MedicalRecord updateRecord(Long id, MedicalRecord newRecord) {
        return repository.findById(id).map(record -> {
            record.setDiagnosis(newRecord.getDiagnosis());
            record.setPrescriptions(newRecord.getPrescriptions());
            record.setTestResults(newRecord.getTestResults());
            record.setVisitDate(newRecord.getVisitDate());
            return repository.save(record);
        }).orElse(null);
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}
