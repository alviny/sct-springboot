package com.sct.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sct.dao.PurchasedItemDAO;
import com.sct.rest.controller.ItemController;

@Configuration
@PropertySource(
        value={"classpath:/database.properties"},
        ignoreResourceNotFound = true)
public class SctSpringBootConfig {
	private static final Logger logger = Logger.getLogger(SctSpringBootConfig.class);
	
	@Value("${db.classname}")
	private String dbClassName;
	@Value("${db.url}")
	private String dbUrl;
	@Value("${db.username}")
	private String dbUsername;
	@Value("${db.password}")
	private String dbPassword;
	
	@Bean
	public DataSource dataSource() {
		logger.info("dbUrl:" + dbUrl);
		logger.info("dbUsername:" + dbUsername);
		logger.info("dbPassword:" + dbPassword);

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(dbClassName);
		ds.setUrl(dbUrl);
		ds.setUsername(dbUsername);
		ds.setPassword(dbPassword);
		return ds;
	}
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }
    @Bean
    public PurchasedItemDAO purchasedItemDAO() {
    		PurchasedItemDAO dao = new PurchasedItemDAO(jdbcTemplate());
    		return dao;
    }
    @Bean
    public JdbcTemplate jdbcTemplate() {
    		JdbcTemplate template = new JdbcTemplate(dataSource());
    		return template;
    }
}
