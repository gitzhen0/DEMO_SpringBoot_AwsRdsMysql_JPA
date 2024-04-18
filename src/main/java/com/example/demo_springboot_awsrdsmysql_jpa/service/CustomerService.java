package com.example.demo_springboot_awsrdsmysql_jpa.service;

import com.example.demo_springboot_awsrdsmysql_jpa.domain.Customer;
import com.example.demo_springboot_awsrdsmysql_jpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository){
        this.repository = repository;
    }

    public Customer saveCustomer(Customer customer){
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    public Customer getCustomerById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Customer customer){
        return repository.save(customer);
    }

    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }
}
