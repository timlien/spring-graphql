package com.tingshulien.springgraphql.sec02.customtype;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  public Optional<Customer> findById(Long id) {
    return customerRepository.findById(id);
  }

  public List<Customer> findByName(String name) {
    return customerRepository.findByNameContainingIgnoreCase(name);
  }

  public List<Customer> findByAgeBetween(int minAge, int maxAge) {
    return customerRepository.findByAgeBetween(minAge, maxAge);
  }

}
