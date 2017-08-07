package com.yandimirov.navi.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void configureMessageConverters(
      final List<HttpMessageConverter<?>> converters
  ) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Stream.of(RequestView.class.getDeclaredClasses())
        .sequential()
        .map(
            jsonViewClass -> {
              MappingJackson2HttpMessageConverter converter =
                  new MappingJackson2HttpMessageConverter();
              ObjectMapper mapper =
                  new ObjectMapper() {
                    @Override
                    protected DefaultSerializerProvider _serializerProvider(
                        final SerializationConfig config) {
                      return super._serializerProvider(
                          config.withView(jsonViewClass)
                      );
                    }
                  };
              mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
              mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
              mapper.setDateFormat(dateFormat);
              converter.setObjectMapper(mapper);
              return converter;
            })
        .collect(Collectors.toCollection(() -> converters));
  }
}
