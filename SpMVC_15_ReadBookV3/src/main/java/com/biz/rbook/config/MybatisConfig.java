package com.biz.rbook.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.driver.OracleDriver;

@Configuration
@EnableTransactionManagement
@MapperScan("com.biz.rbook.repository")
public class MybatisConfig {

	@Bean
	public DataSource oracleDs() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("book");
		ds.setPassword("book");
		
		return ds;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlFactory() {
		
		SqlSessionFactoryBean sb = new SqlSessionFactoryBean();
		sb.setDataSource(oracleDs());
		sb.setTypeAliasesPackage("com.biz.rbook.domain");
		return sb;
	}
	
	@Bean
	public DataSourceTransactionManager tm() {
		DataSourceTransactionManager tm
			= new DataSourceTransactionManager( oracleDs() );
		
		return tm;
	}
	
}
