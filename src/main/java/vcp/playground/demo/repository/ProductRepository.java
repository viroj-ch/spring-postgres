package vcp.playground.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vcp.playground.demo.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

  List<Product> findByName(String name);
}
