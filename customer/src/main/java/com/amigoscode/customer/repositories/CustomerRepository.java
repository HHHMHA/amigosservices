package com.amigoscode.customer.repositories;

import com.amigoscode.customer.models.Customer;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
