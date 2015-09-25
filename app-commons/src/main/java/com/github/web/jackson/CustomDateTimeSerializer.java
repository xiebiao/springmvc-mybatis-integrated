package com.github.web.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author xiebiao
 * @date 3/4/15
 */
public class CustomDateTimeSerializer extends JsonSerializer<Date> {
  @Override
  public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = formatter.format(value);
    jgen.writeString(formattedDate);
  }
}
