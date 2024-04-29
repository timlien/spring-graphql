package com.tingshulien.springgraphql.sec04.datafetcherbean;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
@RequiredArgsConstructor
public class DataFetcherConfig {

  private final BookStoreDataFetcher dataFetcher;

  @Bean
  public RuntimeWiringConfigurer configurer(){
    return c -> c.type("Query", b -> b.dataFetcher("bookStoreDtos", this.dataFetcher));
  }

}
