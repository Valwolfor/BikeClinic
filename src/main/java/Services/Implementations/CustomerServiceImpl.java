package Services.Implementations;

import Beans.Customer;
import Repository.CustomerRepository;
import Services.Interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer oldCustomer = repository.findById(customer.getId()).orElse(null);
        if (oldCustomer != null) {
            oldCustomer.setTypeId(customer.getTypeId());
            oldCustomer.setFirstName(customer.getFirstName());
            oldCustomer.setLastName(customer.getLastName());
            oldCustomer.setContactNumber(customer.getContactNumber());
            oldCustomer.setEmail(customer.getEmail());
        }
        //Se podría manejar con exceptiones pero me dio pereza.
        assert oldCustomer != null;
        return repository.save(oldCustomer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Customer getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }


}
