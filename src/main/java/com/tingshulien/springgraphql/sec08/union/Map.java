package com.tingshulien.springgraphql.sec08.union;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "newInstance")
public class Map {

  private final String location;

}
