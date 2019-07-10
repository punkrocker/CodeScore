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
@MapperScan(basePackages = "com.yuhaokui.statistics.mapper.sonar")
public class SonarDataSourceConfig {



//    @Bean(name = "sonarSqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("sonarDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:com/yuhaokui/statistics/mapper/sonar/*.xml"));
//        return sessionFactoryBean.getObject();
//    }

    @Bean(name = "sonarTemplate")
    public JdbcTemplate gitTemplate(@Qualifier("sonarDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
