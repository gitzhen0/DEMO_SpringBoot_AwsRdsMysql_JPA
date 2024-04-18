package com.example.demo_springboot_awsrdsmysql_jpa.repository;

import com.example.demo_springboot_awsrdsmysql_jpa.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
