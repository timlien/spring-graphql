package com.tingshulien.springgraphql.sec03.nestedobjects;

import java.util.List;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findByBookStoreId(Long bookStoreId);

  List<Book> findByBookStoreId(Long bookStoreId, Limit limit);

  List<Book> findByBookStoreIdIn(List<Long> bookStoreIds);

}
