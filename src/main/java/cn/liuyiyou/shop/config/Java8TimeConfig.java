package cn.liuyiyou.shop.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/***
 *
 * 解决：前天2018-03-16T11:33:00 这样的日期格式
 * @author: liuyiyou.cn
 * @date: 2019/2/21
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Configuration
public class Java8TimeConfig {

    @Value("${spring.jackson.date-format}")
    private String pattern;

    @Bean
    LocalDateTimeSerializer localDateTimeSerializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
    }

    @Bean
    public LocalDateTimeDeserializer localDateTimeDeserializer() {
        return new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(pattern));
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder ->
                jacksonObjectMapperBuilder
                        .serializerByType(LocalDateTime.class, localDateTimeSerializer())
                        .deserializerByType(LocalDateTime.class, localDateTimeDeserializer());
    }
}
