package com.hms.medical_records_service.controller;

import com.hms.medical_records_service.model.MedicalRecord;
import com.hms.medical_records_service.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    // Add new record
    @PostMapping
    public MedicalRecord addRecord(@RequestBody MedicalRecord record) {
        return service.saveRecord(record);
    }

    // Get record by ID
    @GetMapping("/{id}")
    public MedicalRecord getRecordById(@PathVariable Long id) {
        return service.getRecordById(id);
    }

    // Get all records of a patient
    @GetMapping("/patient/{patientId}")
    public List<MedicalRecord> getRecordsByPatient(@PathVariable Long patientId) {
        return service.getRecordsByPatient(patientId);
    }

    // Get all records
    @GetMapping
    public List<MedicalRecord> getAllRecords() {
        return service.getAllRecords();
    }

    // Update record
    @PutMapping("/{id}")
    public MedicalRecord updateRecord(@PathVariable Long id, @RequestBody MedicalRecord record) {
        return service.updateRecord(id, record);
    }

    // Delete record
    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
        return "Medical Record with ID " + id + " deleted successfully!";
    }
}
