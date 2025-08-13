package com.emirhansoylu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emirhansoylu.entities.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
