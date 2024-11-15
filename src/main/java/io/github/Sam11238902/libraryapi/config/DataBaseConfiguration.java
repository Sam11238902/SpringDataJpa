package io.github.Sam11238902.libraryapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// configuracao do hikari 
///https://github.com/brettwooldridge/HikariCP


@Configuration
public class DataBaseConfiguration {
	
	// GUARDANDO AS PROPRIEDADES DO ARQUIVO APLICATION.YML DENTRO DAS VARIAVEIS.

	@Value("${spring.datasource.url}")
	String url;

	@Value("${spring.datasource.username}")
	String username;

	@Value("${spring.datasource.password}")
	String password;

	@Value("${spring.datasource.driver-class-name}")
	String driver;

	// ESSE DATASOURCE ABAIXO ELE É A IMPLEMENTACAO MININMA , NO CASO ELE NÃO É
	// UTILIZADO , O UTILIZADO É O HIKARI POIS É
	// MAIS ROBUSTO.

	
	/*
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();

		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setDriverClassName(driver);

		return ds;

	}
	*/
	
	
	
	
	@Bean
	public DataSource hikkariDataSouce() {
		// CRIA UMA CONFIG , DEPOIS INSTASNCIA UM DATASOURCE PASSANDO AS CONFIGS .
		HikariConfig dbConfig = new HikariConfig();
		
		dbConfig.setJdbcUrl(url);
		dbConfig.setUsername(username);
		dbConfig.setPassword(password);
		dbConfig.setDriverClassName(driver);
		
		dbConfig.setMaximumPoolSize(10); // maximo de conexoes possiveis com o banco de dados.
		dbConfig.setMinimumIdle(1); // inicia com uma conecacao e vai ao maximum 10. 
		dbConfig.setPoolName("library-db-poll"); // poll name 
		dbConfig.setMaxLifetime(600000); // 600000 milisegundos (10 minutos) tempo maximo da conexao , depoiis vai morrer .
		dbConfig.setConnectionTimeout(100000); // tempo que vai esperar fazzer uma conexao .
		
		dbConfig.setConnectionTestQuery("select 1"); // query de teste .
		
		
		HikariDataSource db = new HikariDataSource(dbConfig);
		
		return db;
	}

}
