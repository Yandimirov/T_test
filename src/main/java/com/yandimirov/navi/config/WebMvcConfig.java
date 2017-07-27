package com.yandimirov.navi.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        List<Class> requestViewsList = Arrays.asList(RequestView.class.getDeclaredClasses());
        requestViewsList.forEach(clazz -> {
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            ObjectMapper mapper = new ObjectMapper(){
                @Override
                protected DefaultSerializerProvider _serializerProvider(SerializationConfig config){
                    return super._serializerProvider(config.withView(clazz));
                }
            };
            mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
            converter.setObjectMapper(mapper);
            converters.add(converter);
        });
    }
}
