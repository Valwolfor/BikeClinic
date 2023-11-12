package com.motorclinic.controller;

import com.motorclinic.entity.DTO.RecordServiceProductDTO;
import com.motorclinic.entity.RecordServiceProduct;
import com.motorclinic.services.interfaces.RecordService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public ResponseEntity<List<RecordServiceProduct>> getAllRecords() {
        List<RecordServiceProduct> records = recordService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordServiceProductDTO> getRecordById(@PathVariable Long id) {
        try {
            RecordServiceProductDTO recordDTO = recordService.getRecordById(id);
            return new ResponseEntity<>(recordDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            // Manejar la excepción cuando no se encuentra el registro
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Manejar otras excepciones de manera genérica
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<RecordServiceProduct> createRecord(@RequestBody RecordServiceProduct record) {
        RecordServiceProduct createdRecord = recordService.createRecord(record);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecordServiceProduct> updateRecord(@PathVariable Long id, @RequestBody RecordServiceProduct record) {
        record.setId(id);
        RecordServiceProduct updatedRecord = recordService.updateRecord(record);
        return (updatedRecord != null) ?
                new ResponseEntity<>(updatedRecord, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
