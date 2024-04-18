package com.example.demo_springboot_awsrdsmysql_jpa.controller;

import com.example.demo_springboot_awsrdsmysql_jpa.domain.Customer;
import com.example.demo_springboot_awsrdsmysql_jpa.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer savedCustomer = service.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

//    Post request Json Sample
//    {
//        "age": 18,
//        "firstName": "bob",
//        "lastName":"stevens",
//        "status": true
//    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = service.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = service.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    //provide id in url, other customer properties in requestbody
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customer.setId(id);
        Customer updatedCustomer = service.updateCustomer(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        service.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
