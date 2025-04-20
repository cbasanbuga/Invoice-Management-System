package com.cba.invoices.service;

import com.cba.invoices.entity.Customer;
import com.cba.invoices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<Customer> save(Customer customer){
        try {
            customerRepository.save(customer);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }
}
