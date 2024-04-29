package com.tingshulien.springgraphql.sec03.nestedobjects;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookStoreService {

  private final BookStoreRepository bookStoreRepository;

  private final BookRepository bookRepository;

  public List<BookStore> allBookStores() {
    return bookStoreRepository.findAll();
  }

  public List<BookStore> allBookStoresAndBooks() {
    var bookStores = bookStoreRepository.findAll();
    for (BookStore store : bookStores) {
      store.setBooksConcurrent(bookRepository.findByBookStoreId(store.getId()));
    }

    return bookStores;
  }

}
