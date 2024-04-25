package com.tingshulien.springgraphql.sec02.customtype;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  /**
   * Query example: { customers { age email id name } }
   *
   * @return List<Customer>
   */
  @QueryMapping
  public List<Customer> customers() {
    return customerService.findAll();
  }

  /**
   * Query example: { customerById(id: "1") { id name email age } }
   *
   * @param id Long
   * @return Customer
   */
  @QueryMapping
  public Customer customerById(@Argument Long id) {
    return customerService.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Customer " + id + " not found"));
  }

  /**
   * Query example: { customersByName(name: "j") { age email id name } }
   *
   * @param name String
   * @return List<Customer>
   */
  @QueryMapping
  public List<Customer> customersByName(@Argument String name) {
    return customerService.findByName(name);
  }

  /**
   * Query example: { customersByAge(ageFilter: {minAge: 20, maxAge: 40}) { age email id name } }
   *
   * @param ageFilter AgeFilter
   * @return List<Customer>
   */
  @QueryMapping
  public List<Customer> customersByAge(@Argument AgeFilter ageFilter) {
    return customerService.findByAgeBetween(ageFilter.getMinAge(), ageFilter.getMaxAge());
  }

}
