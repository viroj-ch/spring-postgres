package vcp.playground.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vcp.playground.demo.entity.Product;
import vcp.playground.demo.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  ProductService service;

  @GetMapping("/products/sum")
  List<Product> getSumOfAllProducts() {
    return service.getSumOfAllProducts();
  }

  @GetMapping("/products/{name}/sum")
  List<Product> getSumOfProductName(@PathVariable String name) {
    return service.getSumOfProductName(name);
  }

}
