package com.example.task.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
@Transactional(readOnly=true)
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByUsername(String username);
}
