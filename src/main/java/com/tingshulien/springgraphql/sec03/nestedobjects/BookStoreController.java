package com.tingshulien.springgraphql.sec03.nestedobjects;

import graphql.schema.DataFetchingFieldSelectionSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookStoreController {

  private final BookStoreService bookStoreService;

  /**
   * Query example { bookStores { id name } }
   *
   * @return list of book stores
   */
  @QueryMapping
  public List<BookStore> bookStores(DataFetchingFieldSelectionSet selectionSet) {
    // If the query contains the field "booksConcurrent", then we don't want to fetch all books sequentially
    if (selectionSet.contains("booksConcurrent")) {
      return bookStoreService.allBookStoresAndBooks();
    }

    return bookStoreService.allBookStores();
  }

}
