package com.tingshulien.springgraphql.sec09.mutation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "newInstance")
public class DeleteResponseDto {

  private Integer id;
  private Status status;

}
