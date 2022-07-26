package fr.fms.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import fr.fms.entities.Customer;

@Service
public interface ICustomerService {
    List<Customer> getCustomer();

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);

    Optional<Customer> readCustomer(Long id);
}
