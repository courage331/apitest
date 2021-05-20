package com.example.apitest.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableJpaRepositories(basePackages = "com.example.apitest.repository.mall", entityManagerFactoryRef = "apiEntityManager2", transactionManagerRef = "apiTransactionManager2")
public class DBConfig2 {
	@Autowired
	private Environment env;

	private static final String prefix = "spring.test2.datasource.";

	@Bean(name = "apiEntityManager2")
	// @Primary
	public LocalContainerEntityManagerFactoryBean apiEntityManager() {
		// log.info("LocalContainerEntityManagerFactoryBean");
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dbMallDataSource());
		em.setPackagesToScan(new String[] { "com.example.apitest.vo" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		Map<String, Object> jpaProperties = new HashMap<>();
		em.setJpaPropertyMap(jpaProperties);
		return em;
	}

	@Bean(name = "apiTransactionManager2")
	// @Primary
	public PlatformTransactionManager dbMallTransactionManager() {
		// log.info("dbMallTransactionManager");

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(apiEntityManager().getObject());

		return transactionManager;
	}

	@Bean(name = "hikari2")
	// @Bean
	// @Primary
	public HikariDataSource dbMallDataSource() {
		// log.info("dbMallDataSource");

		HikariConfig config = new HikariConfig();

		config.setJdbcUrl(env.getProperty(prefix + "url"));
		config.setUsername(env.getProperty(prefix + "username"));
		config.setPassword(env.getProperty(prefix + "password"));
		config.setMaxLifetime(Long.parseLong(env.getProperty(prefix + "hikari.max-lifetime")));
		config.setConnectionTimeout(Long.parseLong(env.getProperty(prefix + "hikari.connection-timeout")));
		config.setValidationTimeout(Long.parseLong(env.getProperty(prefix + "hikari.validation-timeout")));
		config.addDataSourceProperty("cachePrepStmts", env.getProperty(prefix + "hikari.data-source-properties.cachePrepStmts"));
		config.addDataSourceProperty("prepStmtCacheSize", env.getProperty(prefix + "hikari.data-source-properties.prepStmtCacheSize"));
		config.addDataSourceProperty("prepStmtCacheSqlLimit", env.getProperty(prefix + "hikari.data-source-properties.prepStmtCacheSqlLimit"));
		config.addDataSourceProperty("useServerPrepStmts", env.getProperty(prefix + "hikari.data-source-properties.useServerPrepStmts"));

		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource;
	}

}
