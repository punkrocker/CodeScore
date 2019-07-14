package com.yuhaokui.statistics.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "gitDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.git")
    public DataSource gitDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sonarDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sonar")
    public DataSource sonarDataSource() {
        return DataSourceBuilder.create().build();
    }
}
