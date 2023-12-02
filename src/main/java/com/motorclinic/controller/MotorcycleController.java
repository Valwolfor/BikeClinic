package com.motorclinic.controller;

import com.motorclinic.entity.Customer;
import com.motorclinic.entity.Motorcycle;
import com.motorclinic.services.interfaces.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    @Autowired
    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    //Checked
    @GetMapping
    public ResponseEntity<List<Motorcycle>> getAllMotorcycles() {
        List<Motorcycle> motorcycles = motorcycleService.getAllMotorcycle();
        return new ResponseEntity<>(motorcycles, HttpStatus.OK);
    }

    //Checked
    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> getMotorcycleById(@PathVariable Long id) {
        Motorcycle motorcycle = motorcycleService.getMotorcycleById(id);
        return (motorcycle != null) ?
                new ResponseEntity<>(motorcycle, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //TODO: innecesario
//    @GetMapping("/owner/{customerId}")
//    public ResponseEntity<Motorcycle> getMotorcycleByOwner(@PathVariable Long customerId) {
//        Customer customer = // Obtener el objeto Customer a partir del ID proporcionado
//                Motorcycle motorcycle = motorcycleService.getMotorcycleByOwner(customer);
//        return ResponseEntity.ok().body(motorcycle);
//    }

    @GetMapping("/plate/{plate}")
    public ResponseEntity<Motorcycle> getMotorcycleByPlate(@PathVariable String plate) {
        Motorcycle motorcycle = motorcycleService.getMotorcycleByPlate(plate);
        return ResponseEntity.ok().body(motorcycle);
    }

    //Checked
    @PostMapping
    public ResponseEntity<Motorcycle> createMotorcycle(@RequestBody Motorcycle motorcycle) {
        Motorcycle createdMotorcycle = motorcycleService.createMotorcycle(motorcycle);
        return new ResponseEntity<>(createdMotorcycle, HttpStatus.CREATED);
    }

    //Checked
    @PutMapping("/{id}")
    public ResponseEntity<Motorcycle> updateMotorcycle(@PathVariable Long id, @RequestBody Motorcycle motorcycle) {
        motorcycle.setId(id);
        Motorcycle updatedMotorcycle = motorcycleService.updateMotorcycle(motorcycle);
        return (updatedMotorcycle != null) ?
                new ResponseEntity<>(updatedMotorcycle, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //Checked
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorcycle(@PathVariable Long id) {
        motorcycleService.deleteUMotorcycle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
