package com.tingshulien.springgraphql.sec04.datafetcherbean;

import com.tingshulien.springgraphql.sec03.nestedobjects.BookService;
import com.tingshulien.springgraphql.sec03.nestedobjects.BookStore;
import com.tingshulien.springgraphql.sec03.nestedobjects.BookStoreService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookStoreDataFetcher implements DataFetcher<List<BookStoreDto>> {

  private final BookStoreService bookStoreService;

  private final BookService bookService;

  @Override
  public List<BookStoreDto> get(DataFetchingEnvironment environment) throws Exception {
    var includeBooks = environment.getSelectionSet().contains("books");
    var bookStores = bookStoreService.allBookStores();
    var booksByStore = bookService.mapAllBooksIn(bookStores);
    return bookStores.stream()
        .map(store -> BookStoreDto.newInstance(store.getId(), store.getName(),
            includeBooks ? booksByStore.get(store) : Collections.emptyList()))
        .toList();
  }

}
