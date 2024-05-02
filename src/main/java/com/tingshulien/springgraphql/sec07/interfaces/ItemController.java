package com.tingshulien.springgraphql.sec07.interfaces;

import java.time.LocalDate;
import java.util.List;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {

  /**
   * example query: query Items { items { id price type: __typename ... on Food { expiryDate } ...
   * on Furniture { material } ... on Electronic { warranty } } }
   *
   * @return list of items
   */
  @QueryMapping
  public List<Object> items() {
    return List.of(
        Foodie.newInstance(50.0F, LocalDate.now().plusDays(7)),
        Furniture.newInstance(100.0F, "wood"),
        Electronic.newInstance(200.0F, 2)
    );
  }

}
