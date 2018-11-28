package com.icafruta.sispack.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alxnderq on 13/11/2016.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.icafruta.sispack.controller" })
public class AppWebConfig {

}
