package vcp.playground.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vcp.playground.demo.entity.Customer;
import vcp.playground.demo.repository.CustomerRepository;

import java.util.List;

@Service
@Slf4j
public class CustomerService {
  @Autowired
  private CustomerRepository repository;

  public void addExampleCustomers() {
    List allCustomers = this.repository.findAll();
    log.info("Number of customers: " + allCustomers.size());

    Customer newCustomer = new Customer();
    newCustomer.setFirstName("John");
    newCustomer.setLastName("Doe");
    log.info("Saving new customer...");
    this.repository.save(newCustomer);

    allCustomers = this.repository.findAll();
    log.info("Number of customers: " + allCustomers.size());
  }
}
