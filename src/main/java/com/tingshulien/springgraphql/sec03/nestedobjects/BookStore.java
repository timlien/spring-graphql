package com.tingshulien.springgraphql.sec03.nestedobjects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "book_store")
public class BookStore {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @Transient
  private List<Book> booksConcurrent;

}
