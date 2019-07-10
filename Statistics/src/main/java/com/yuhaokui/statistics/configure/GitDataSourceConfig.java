package com.yuhaokui.statistics.configure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.yuhaokui.statistics.mapper.git")
public class GitDataSourceConfig {


    @Bean(name = "gitTemplate")
    public JdbcTemplate gitTemplate(@Qualifier("gitDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
