package com.tingshulien.springgraphql.sec06.scalartypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "newInstance")
public class Car {

  private UUID number;
  private String name;
  private Integer height;
  private Float tank;
  private Boolean secondHand;

  private Long serialNumber;
  private Byte ageInYears; // -128 to 127
  private Short ageInMonths;
  private BigDecimal price;
  private BigInteger distance;
  private LocalDate createDate;
  private LocalTime createTime;
  private OffsetDateTime createDateTime;
  private CarType Type;

}
