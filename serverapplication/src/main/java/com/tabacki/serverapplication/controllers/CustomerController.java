package com.tabacki.serverapplication.controllers;

import com.tabacki.serverapplication.entities.Customer;
import com.tabacki.serverapplication.entities.LastChange;
import com.tabacki.serverapplication.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    private LastChange lastChange = new LastChange();

    @GetMapping("/getcustomers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/deletecustomer/{id}/{name}/{surname}/{email}")
    public void deleteCustomer(@PathVariable Long id, @PathVariable String name, @PathVariable String surname, @PathVariable String email) {
        customerRepository.delete(new Customer(id, name, surname, email));
        lastChange.update();
    }

    @GetMapping("/addcustomer/{name}/{surname}/{email}")
    public void addCustomer(@PathVariable String name, @PathVariable String surname, @PathVariable String email) {
        customerRepository.save(new Customer(name, surname, email));
        lastChange.update();
    }

    @GetMapping("/getlastchange")
    public LastChange getLastChange(){
        return lastChange;
    }
}
