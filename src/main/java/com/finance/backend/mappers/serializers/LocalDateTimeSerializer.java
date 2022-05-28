package com.finance.backend.mappers.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
  private final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

  @Override
  public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    final String dateString = value.format(formatter);
    gen.writeString(dateString);
  }
}
