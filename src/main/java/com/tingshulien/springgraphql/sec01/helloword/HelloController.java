package com.tingshulien.springgraphql.sec01.helloword;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

  /**
   * Query example: { hello }
   *
   * @return String
   */
  @QueryMapping("hello")
  public String helloWorld() {
    return "Hello, World!";
  }

  /**
   * Query example: { helloTo(name: "Alice") }
   *
   * @param name String
   * @return String
   */
  @QueryMapping("helloTo")
  public String helloName(@Argument("name") String name) {
    return "Hello, " + name + "!";
  }

}
