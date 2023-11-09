package Services.Interfaces;

import Beans.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Integer id);

    Customer getCustomerById(Integer id);

    Customer getByEmail(String email);

    List<Customer> getAllCustomers();
}
