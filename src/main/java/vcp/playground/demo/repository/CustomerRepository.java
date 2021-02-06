package vcp.playground.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vcp.playground.demo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
