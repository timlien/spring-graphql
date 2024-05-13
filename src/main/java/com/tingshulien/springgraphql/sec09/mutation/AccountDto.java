package com.tingshulien.springgraphql.sec09.mutation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "newInstance")
public class AccountDto {

  private Integer id;
  private String name;
  private Integer age;

}
