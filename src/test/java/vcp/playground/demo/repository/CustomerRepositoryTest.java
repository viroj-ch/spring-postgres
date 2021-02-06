package vcp.playground.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vcp.playground.demo.entity.Customer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class CustomerRepositoryTest {

  @Autowired
  private CustomerRepository repository;

  @Test
  void SaveOneCustomerToDatabase() {

    //Given
    Customer newCustomer = new Customer();
    newCustomer.setFirstName("John");
    newCustomer.setLastName("Doe");

    //When
    repository.save(newCustomer);

    //Then
    assertThat(repository.findById(1L), is(notNullValue()));
  }
}