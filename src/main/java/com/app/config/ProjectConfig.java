package com.app.config;




import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
//@PropertySource("classpath:database.properties")
@PropertySources({ @PropertySource("classpath:database.properties"), 
	               @PropertySource("classpath:temp.yml") })
@ComponentScan(basePackages = {"com.app.service","com.app.repo"})
public class ProjectConfig {
	@Autowired
	private Environment environment;
	
	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";
	
	@Bean
	public DataSource dataSource() {
//		System.out.println("Data source creation started");
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		//driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/arjun");
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
//		System.out.println(" Property from the class path " +environment.getProperty(URL));
		return driverManagerDataSource;
	}
	
//	@Bean 
//	public TempBean tempBean() {
//		System.out.println("========" +environment.getProperty("username"));
//		return new TempBean();
//	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
	//	System.out.println("JdbcTemplate creation started");
		return new JdbcTemplate(dataSource());
	}

}
