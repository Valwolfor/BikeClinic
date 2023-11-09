package Controller;

import Beans.Motorcycle;
import Services.Interfaces.MotorcycleService;
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

    @GetMapping
    public ResponseEntity<List<Motorcycle>> getAllMotorcycles() {
        List<Motorcycle> motorcycles = motorcycleService.getAllMotorcycle();
        return new ResponseEntity<>(motorcycles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> getMotorcycleById(@PathVariable Long id) {
        Motorcycle motorcycle = motorcycleService.getMotorcycleById(id);
        return (motorcycle != null) ?
                new ResponseEntity<>(motorcycle, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Motorcycle> createMotorcycle(@RequestBody Motorcycle motorcycle) {
        Motorcycle createdMotorcycle = motorcycleService.createMotorcycle(motorcycle);
        return new ResponseEntity<>(createdMotorcycle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motorcycle> updateMotorcycle(@PathVariable Long id, @RequestBody Motorcycle motorcycle) {
        motorcycle.setId(id);
        Motorcycle updatedMotorcycle = motorcycleService.updateMotorcycle(motorcycle);
        return (updatedMotorcycle != null) ?
                new ResponseEntity<>(updatedMotorcycle, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorcycle(@PathVariable Long id) {
        motorcycleService.deleteUMotorcycle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
