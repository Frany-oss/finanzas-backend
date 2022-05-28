package com.finance.backend.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.finance.backend.mappers.serializers.BigDecimalSerializer;
import com.finance.backend.mappers.serializers.LocalDateSerializer;
import com.finance.backend.mappers.serializers.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectMapperConfig {
  @Bean
  @Primary
  public static ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();

    var timeModule = new JavaTimeModule();
    timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
    timeModule.addSerializer(LocalDate.class, new LocalDateSerializer());

    var simpleModule = new SimpleModule();
    simpleModule.addSerializer(BigDecimal.class, new BigDecimalSerializer());

    mapper.registerModule(timeModule);
    mapper.registerModule(simpleModule);
    mapper.registerModule(new Jdk8Module());

    return mapper;
  }
}
