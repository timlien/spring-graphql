package com.tingshulien.springgraphql.sec03.nestedobjects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

}
