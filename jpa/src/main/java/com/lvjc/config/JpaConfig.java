package com.lvjc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

import java.util.logging.Logger;

@Configuration
@EnableJpaRepositories("com.lvjc.repository")
@EnableTransactionManagement
public class JpaConfig {

	@Autowired
	DataSource dataSource;


	@Bean(name="jdbcTemplate")
	JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}




}
