package com.tingshulien.springgraphql.sec05.fieldglobpattern;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class FieldGlobPatternController {

  @QueryMapping
  public Object level1(DataFetchingFieldSelectionSet selectionSet) {

    log.info("Contains level2 : {}", selectionSet.contains("level2"));
    log.info("Contains level2/level3 : {}", selectionSet.contains("level2/level3"));
    log.info("Contains */level3 : {}", selectionSet.contains("*/level3"));
    log.info("Contains **/level3 : {}", selectionSet.contains("**/level3"));
    log.info("Contains level2/*/level5 : {}", selectionSet.contains("level2/*/level5"));
    log.info("Contains level2/**/level5 : {}", selectionSet.contains("level2/**/level5"));

    return null;
  }

}
