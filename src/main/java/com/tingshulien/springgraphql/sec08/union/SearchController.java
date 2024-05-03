package com.tingshulien.springgraphql.sec08.union;

import java.util.List;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SearchController {

  /**
   * Query example: { search { ... on Image { blob } ... on Website { url } ... on Map { location }
   * } }
   *
   * @return list of search result objects
   */
  @QueryMapping
  public List<Object> search() {
    return List.of(
        Website.newInstance("https://www.google.com"),
        Image.newInstance("blob"),
        Map.newInstance("Taipei")
    );
  }

}
