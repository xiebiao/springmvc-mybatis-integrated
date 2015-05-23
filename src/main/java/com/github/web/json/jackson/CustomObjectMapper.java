package com.github.web.json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author xiebiao
 * @date 3/4/15
 */
public class CustomObjectMapper extends ObjectMapper {
  public CustomObjectMapper() {
    super();
    // 值为null的节点不返回
    this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    // 允许单引号
    this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    // 字段和值都加引号
    this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    // 数字也加引号
    // this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
    // this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);

    // // 空值处理为空串
    // this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
    // @Override
    // public void serialize(Object value, JsonGenerator jg, SerializerProvider sp)
    // throws IOException {
    // jg.writeString("");
    // }
    // });

  }
}
