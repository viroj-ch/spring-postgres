package vcp.playground.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vcp.playground.demo.entity.Product;
import vcp.playground.demo.repository.ProductRepository;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Slf4j
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public void addExampleProducts() {

    List<Product> products = newArrayList(
        Product.builder().name("abc").groupId(1).price(10.0).isActive(true).build(),
        Product.builder().name("abc").groupId(1).price(10.0).isActive(true).build(),
        Product.builder().name("abc").groupId(1).price(10.0).isActive(false).build(),
        Product.builder().name("abc").groupId(2).price(10.0).isActive(true).build(),
        Product.builder().name("abc").groupId(2).price(10.0).isActive(true).build(),
        Product.builder().name("abc").groupId(2).price(10.0).isActive(true).build(),
        Product.builder().name("xxx").groupId(2).price(10.0).isActive(true).build(),
        Product.builder().name("abc").groupId(3).price(10.0).isActive(true).build()
    );

    repository.saveAll(products);
  }

}
