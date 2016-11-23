package com.icafruta.sispack.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alxnderq on 13/11/2016.
 */
@Configuration
@ComponentScan(basePackages = { "com.icafruta.sispack.service.impl", "com.icafruta.sispack.utils" })
public class AppConfig {
}
