package Services.Implementations;

import Beans.Customer;
import Beans.Motorcycle;
import Repository.MotorcycleRepository;
import Services.Interfaces.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MotorcycleServiceImpl implements MotorcycleService {

    private final MotorcycleRepository repository;

    @Autowired
    public MotorcycleServiceImpl(MotorcycleRepository repository) {
        this.repository = repository;
    }
    @Override
    public Motorcycle createMotorcycle(Motorcycle motorcycle) {
        return repository.save(motorcycle);
    }

    @Override
    public Motorcycle updateMotorcycle(Motorcycle motorcycle) {
        Motorcycle oldMotor = repository.findById(motorcycle.getId()).orElse(null);
        if (oldMotor != null) {
            //no cambia ni id ni placa.
            oldMotor.setBrand(motorcycle.getBrand());
            oldMotor.setCustomer(motorcycle.getCustomer());
            oldMotor.setChassisId(motorcycle.getChassisId());
            oldMotor.setModel(motorcycle.getModel());
            oldMotor.setEngineId(motorcycle.getEngineId());
            oldMotor.setRegistrationYear(motorcycle.getRegistrationYear());
        }
        assert oldMotor != null;
        return repository.save(oldMotor);
    }

    @Override
    public void deleteUMotorcycle(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Motorcycle getMotorcycleById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Motorcycle getMotorcycleByOwner(Customer customer) {
        return repository.findByCustomer(customer);
    }

    @Override
    public Motorcycle getMotorcycleByPlate(String plate) {
        return repository.findByPlate(plate);
    }

    @Override
    public List<Motorcycle> getAllMotorcycle() {
        return repository.findAll();
    }
}
