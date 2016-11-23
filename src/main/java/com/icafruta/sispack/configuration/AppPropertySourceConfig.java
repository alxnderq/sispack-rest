package com.icafruta.sispack.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by alxnderq on 11/22/2016.
 */
@Configuration
@PropertySource({ "classpath:message-error.properties",
        "classpath:message-info.properties",
        "classpath:rest.properties",
        "classpath:token.properties"})
public class AppPropertySourceConfig {

    public static class PropertyConfig {
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

}
