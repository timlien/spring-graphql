package com.tingshulien.springgraphql.sec03.nestedobjects;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  /**
   * Query example { bookStores { id name books { id title } } }
   * <p>
   * This method is used to fetch all books for a given book store. N+1 problem is present here.
   *
   * @param bookStore book store
   * @return list of books
   */
  @SchemaMapping
  public List<Book> books(BookStore bookStore) {
    return bookService.allBooks(bookStore);
  }

  /**
   * Query example { bookStores { id name booksWithLimit(limit: 1) { id title } } }
   * <p>
   * This method is used to fetch all books for a given book store with a limit. N+1 problem is
   * present here.
   *
   * @param bookStore book store
   * @param limit     limit
   * @return list of books
   */
  @SchemaMapping(typeName = "BookStore")
  public List<Book> booksWithLimit(BookStore bookStore, @Argument int limit) {
    return bookService.allBooksLimitTo(bookStore, limit);
  }

  /**
   * Query example { bookStores { id name booksWithoutNPlus1ByList { id title } } }
   * <p>
   * This method is used to fetch all books for a given list of book stores. N+1 problem is fixed.
   *
   * @param bookStores book stores
   * @return list of books
   */
  @BatchMapping(typeName = "BookStore")
  public List<List<Book>> booksWithoutNPlus1ByList(List<BookStore> bookStores) {
    return bookService.listAllBooksIn(bookStores);
  }

  /**
   * Query example { bookStores { id name booksWithoutNPlus1ByMap { id title } } }
   * <p>
   * This method is used to fetch all books for a given list of book stores. N+1 problem is fixed.
   *
   * @param bookStores book stores
   * @return Map of book store and list of books
   */
  @BatchMapping(typeName = "BookStore")
  public Map<BookStore, List<Book>> booksWithoutNPlus1ByMap(List<BookStore> bookStores) {
    return bookService.mapAllBooksIn(bookStores);
  }

}
