//package com.motorclinic.controller;
//
//import com.motorclinic.entity.Status;
//import com.motorclinic.services.interfaces.StatusService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/status")
//public class StatusController {
//
//    private final StatusService statusService;
//
//    @Autowired
//    public StatusController(StatusService statusService) {
//        this.statusService = statusService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Status>> getAllStatus() {
//        List<Status> statuses = statusService.getAllStatuss();
//        return new ResponseEntity<>(statuses, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
//        Status status = statusService.getStatusById(id);
//        return (status != null) ?
//                new ResponseEntity<>(status, HttpStatus.OK) :
//                new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    //Checked
//    @PostMapping
//    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
//        Status createdStatus = statusService.createStatus(status);
//        return new ResponseEntity<>(createdStatus, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status status) {
//        status.setId(id);
//        Status updatedStatus = statusService.updateStatus(status);
//        return (updatedStatus != null) ?
//                new ResponseEntity<>(updatedStatus, HttpStatus.OK) :
//                new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
//        statusService.deleteStatus(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    // Otros métodos de punto final según sea necesario
//}
