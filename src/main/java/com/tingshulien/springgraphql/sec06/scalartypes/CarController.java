package com.tingshulien.springgraphql.sec06.scalartypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CarController {

  @QueryMapping
  public Car car() {
    return Car.newInstance(
        UUID.randomUUID(),
        "CX-5",
        170,
        100.0F,
        false,
        123456789L,
        (byte) 1,
        (short) 1,
        BigDecimal.valueOf(30000),
        BigInteger.valueOf(0),
        LocalDate.now(),
        LocalTime.now(),
        OffsetDateTime.now(),
        CarType.MAZDA
    );
  }

  @QueryMapping
  public List<Product> products() {
    return List.of(
        Product.newInstance("CX-50", Map.of("fuel tank", "150L", "color", "red")),
        Product.newInstance("X1", Map.of("weight", "200KG", "audio", "BASS"))
    );
  }

}
