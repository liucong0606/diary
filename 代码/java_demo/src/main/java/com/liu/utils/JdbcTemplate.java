package com.liu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * ClassName: JdbcTemplate <br/>
 * Description: <br/>
 * date: 2020/8/7 15:32<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
@Configuration
public class JdbcTemplate {
    @Bean
    public static org.springframework.jdbc.core.JdbcTemplate getJdbcTemplate() {
        org.springframework.jdbc.core.JdbcTemplate jt = new org.springframework.jdbc.core.JdbcTemplate(getDataSource());
        return jt;
    }

    public static DataSource getDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/db_school");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
}
