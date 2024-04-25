package com.tingshulien.springgraphql.sec02.customtype;

import lombok.Data;

@Data
public class AgeFilter {

  private int minAge;
  private int maxAge;

}
