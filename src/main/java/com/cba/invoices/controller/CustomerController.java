package com.cba.invoices.controller;

import com.cba.invoices.entity.Customer;
import com.cba.invoices.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("customers")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }


}
