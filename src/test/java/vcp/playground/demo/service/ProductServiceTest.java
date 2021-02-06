package vcp.playground.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vcp.playground.demo.entity.Product;
import vcp.playground.demo.repository.ProductRepository;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.samePropertyValuesAs;

@SpringBootTest
class ProductServiceTest {

  @Autowired
  ProductRepository repository;

  @Autowired
  ProductService service;

  @Test
  public void getSumOfProductsFromDb() {

    //Given
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

    //When
    List<Product> actual = service.sumPriceGroupByGroupIdAndName(products);

    //Then
    List<Product> expected = newArrayList(
        Product.builder().name("abc").groupId(1).price(20.0).isActive(true).build(),
        Product.builder().name("abc").groupId(2).price(30.0).isActive(true).build(),
        Product.builder().name("xxx").groupId(2).price(10.0).isActive(true).build(),
        Product.builder().name("abc").groupId(3).price(10.0).isActive(true).build()
    );
    assertThat(actual, samePropertyValuesAs(expected, "id"));
  }

  @Test
  public void getSumOfProducts() {

    //Given
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

    //When
    List<Product> actual = service.sumPriceGroupByGroupIdAndName(products);

    //Then
    List<Product> expected = newArrayList(
        Product.builder().name("abc").groupId(1).price(20.0).isActive(true).build(),
        Product.builder().name("abc").groupId(2).price(30.0).isActive(true).build(),
        Product.builder().name("xxx").groupId(2).price(10.0).isActive(true).build(),
        Product.builder().name("abc").groupId(3).price(10.0).isActive(true).build()
    );
    assertThat(actual, containsInAnyOrder(expected.toArray()));
  }

}