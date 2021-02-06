package vcp.playground.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import vcp.playground.demo.service.CustomerService;
import vcp.playground.demo.service.ProductService;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Autowired
  CustomerService customerService;

  @Autowired
  ProductService productService;

  @EventListener(ApplicationReadyEvent.class)
  public void runAfterStartup() {

    customerService.addExampleCustomers();
    productService.addExampleProducts();
  }
}
