package com.finance.backend.mappers;

import com.finance.backend.entities.AnioBono;
import java.math.BigDecimal;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ModelMapperConfig {
  @Bean
  @Primary
  public static ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
    mapper.addConverter(
        new Converter<AnioBono, BigDecimal>() {
          @Override
          public BigDecimal convert(MappingContext<AnioBono, BigDecimal> context) {
            return context.getSource() == null ? null : context.getSource().getPerInflacion();
          }
        });
    return mapper;
  }
}
