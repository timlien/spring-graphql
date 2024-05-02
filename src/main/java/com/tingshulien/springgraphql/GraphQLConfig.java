package com.tingshulien.springgraphql;

import com.tingshulien.springgraphql.sec04.datafetcherbean.BookStoreDataFetcher;
import graphql.scalars.ExtendedScalars;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
@RequiredArgsConstructor
public class GraphQLConfig {

  private final BookStoreDataFetcher dataFetcher;

  @Bean
  public RuntimeWiringConfigurer configurer(){
    return c -> c
        // section 04
        .type("Query", b -> b.dataFetcher("bookStoreDtos", this.dataFetcher))

        // section 06
        .scalar(ExtendedScalars.GraphQLLong)
        .scalar(ExtendedScalars.GraphQLByte)
        .scalar(ExtendedScalars.GraphQLShort)
        .scalar(ExtendedScalars.GraphQLBigDecimal)
        .scalar(ExtendedScalars.GraphQLBigInteger)
        .scalar(ExtendedScalars.Date)
        .scalar(ExtendedScalars.LocalTime)
        .scalar(ExtendedScalars.DateTime)
        .scalar(ExtendedScalars.Object);
  }

}
