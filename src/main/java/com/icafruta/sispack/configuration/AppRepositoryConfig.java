package com.icafruta.sispack.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by alxnderq on 11/14/2016.
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.icafruta.sispack.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.icafruta.sispack.entity"})
public class AppRepositoryConfig {

}
