package vcp.playground.demo.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import vcp.playground.demo.entity.Product;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void SumOfAllProducts() throws Exception {

    String json = mockMvc.perform(get("/products/sum").contentType(MediaType.APPLICATION_JSON_VALUE))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    List<Product> actual = new ObjectMapper().readValue(json, new TypeReference<List<Product>>(){});
    List<Product> expected = newArrayList(
        Product.builder().name("abc").groupId(1).price(20.0).isActive(true).build(),
        Product.builder().name("abc").groupId(2).price(30.0).isActive(true).build(),
        Product.builder().name("xxx").groupId(2).price(10.0).isActive(true).build(),
        Product.builder().name("abc").groupId(3).price(10.0).isActive(true).build()
    );
    assertThat(actual, samePropertyValuesAs(expected, "id"));
  }

  @Test
  void SumOfProductByName() throws Exception {

    String json = mockMvc.perform(get("/products/{name}/sum", "xxx").contentType(MediaType.APPLICATION_JSON_VALUE))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    List<Product> actual = new ObjectMapper().readValue(json, new TypeReference<List<Product>>(){});
    List<Product> expected = newArrayList(
        Product.builder().name("xxx").groupId(2).price(10.0).isActive(true).build()
    );
    assertThat(actual, samePropertyValuesAs(expected, "id"));
  }

  @Test
  void SumOfProductByNameNotFound() throws Exception {

    mockMvc.perform(get("/products/{name}/sum", "nothing").contentType(MediaType.APPLICATION_JSON_VALUE))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[]"));
  }
}