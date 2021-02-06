package vcp.playground.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue
  private long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "group_id", nullable = false)
  private long groupId;

  @Column(name = "active", nullable = false)
  private Boolean isActive;
}

