package com.tingshulien.springgraphql;

import com.tingshulien.springgraphql.sec04.datafetcherbean.BookStoreDataFetcher;
import com.tingshulien.springgraphql.sec07.interfaces.Foodie;
import graphql.scalars.ExtendedScalars;
import graphql.schema.TypeResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.ClassNameTypeResolver;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
@RequiredArgsConstructor
public class GraphQLConfig {

  private final BookStoreDataFetcher dataFetcher;

  @Bean
  public RuntimeWiringConfigurer configurer(TypeResolver resolver){
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
        .scalar(ExtendedScalars.Object)

        // section 07
        .type("Item", b -> b.typeResolver(resolver));
  }

  @Bean
  public TypeResolver typeResolver(){
    // section 07
    ClassNameTypeResolver resolver = new ClassNameTypeResolver();
    resolver.addMapping(Foodie.class, "Food");
    return resolver;
  }

}
