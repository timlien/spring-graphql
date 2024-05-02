package com.tingshulien.springgraphql.sec07.interfaces;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "newInstance")
public class Foodie {

  private final UUID id = UUID.randomUUID();
  private final Float price;
  private final LocalDate expiryDate;

}
