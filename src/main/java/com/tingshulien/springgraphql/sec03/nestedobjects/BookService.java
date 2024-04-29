package com.tingshulien.springgraphql.sec03.nestedobjects;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public List<Book> allBooks(BookStore bookStore) {
    return bookRepository.findByBookStoreId(bookStore.getId());
  }

  public List<Book> allBooksLimitTo(BookStore bookStore, int limit) {
    return bookRepository.findByBookStoreId(bookStore.getId(), Limit.of(limit));
  }

  public List<List<Book>> listAllBooksIn(List<BookStore> bookStores) {
    var books = bookRepository.findByBookStoreIdIn(bookStores.stream().map(BookStore::getId).toList());
    var booksByStoreId = books.stream().collect(groupingBy(Book::getBookStoreId));
    var booksListedByStore = new ArrayList<List<Book>>();
    for (BookStore store : bookStores) {
      booksListedByStore.add(booksByStoreId.getOrDefault(store.getId(), Collections.emptyList()));
    }

    return booksListedByStore;
  }

  public Map<BookStore, List<Book>> mapAllBooksIn(Collection<BookStore> bookStores) {
    var books = bookRepository.findByBookStoreIdIn(bookStores.stream().map(BookStore::getId).toList());
    var booksByStoreId = books.stream().collect(groupingBy(Book::getBookStoreId));
    var booksByStore = new HashMap<BookStore, List<Book>>();
    for (BookStore store : bookStores) {
      booksByStore.put(store, booksByStoreId.getOrDefault(store.getId(), Collections.emptyList()));
    }

    return booksByStore;
  }

}
