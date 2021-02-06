package vcp.playground.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vcp.playground.demo.entity.Product;
import vcp.playground.demo.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

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

  public List<Product> sumPriceGroupByGroupIdAndName(List<Product> products) {
    return products.stream()
        .filter(i -> i.getIsActive().equals(true))
        .collect(Collectors.groupingBy(p -> newArrayList(p.getGroupId(), p.getName())))
        .entrySet().stream()
        .map(e -> e.getValue().stream().reduce((l, r) -> l.toBuilder().price(l.getPrice() + r.getPrice()).build()))
        .map(f -> f.get())
        .collect(Collectors.toList());
  }

}
