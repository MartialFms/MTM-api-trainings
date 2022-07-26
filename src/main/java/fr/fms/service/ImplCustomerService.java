package fr.fms.service;

import fr.fms.dao.CustomerRepository;
import fr.fms.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ImplCustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> readCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
