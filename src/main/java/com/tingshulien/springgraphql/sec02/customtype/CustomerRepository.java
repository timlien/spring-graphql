package com.tingshulien.springgraphql.sec02.customtype;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findByNameContainingIgnoreCase(String name);

  List<Customer> findByAgeBetween(int minAge, int maxAge);

}
