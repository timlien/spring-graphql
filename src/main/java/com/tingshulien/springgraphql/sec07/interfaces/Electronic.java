package com.tingshulien.springgraphql.sec07.interfaces;

import java.util.UUID;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "newInstance")
public class Electronic {

  private final UUID id = UUID.randomUUID();
  private final Float price;
  private final int warranty;

}
