package com.finance.backend.mappers.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class LocalDateSerializer extends JsonSerializer<LocalDate> {
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  public void serialize(LocalDate vaue, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    final String dateString = vaue.format(formatter);
    gen.writeString(dateString);
  }
}
