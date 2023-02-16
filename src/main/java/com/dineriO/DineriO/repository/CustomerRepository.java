package com.dineriO.DineriO.repository;

import com.dineriO.DineriO.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
