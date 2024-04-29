package com.tingshulien.springgraphql.sec04.datafetcherbean;

import com.tingshulien.springgraphql.sec03.nestedobjects.Book;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "newInstance")
public class BookStoreDto {

  private Long id;
  private String name;
  private List<Book> books;

}
