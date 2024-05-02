package com.tingshulien.springgraphql.sec06.scalartypes;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "newInstance")
public class Product {

  private String name;
  private Map<String, String> attributes;

}
