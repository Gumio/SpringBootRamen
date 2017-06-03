package com.gumio_inf.ramen

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.web.filter.CharacterEncodingFilter
import javax.sql.DataSource

/**
 * Created by gumio_inf on 2017/05/13.
 */
@Configuration
class AppConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    fun dataSource(): DataSource? = DataSourceBuilder.create().build()
}