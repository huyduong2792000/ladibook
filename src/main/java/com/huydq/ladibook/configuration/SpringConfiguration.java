package com.huydq.ladibook.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan({ "com.huydq.ladibook" })
@EnableJpaRepositories(basePackages = "com.huydq.ladibook.repositories")
@PropertySource(value = "classpath:database.properties")
@EnableTransactionManagement
public class SpringConfiguration {

	@Autowired
	Environment env;

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(new String[] { "com.huydq.ladibook.entity" });

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setJpaProperties(additionalProperties());

		return entityManagerFactoryBean;
	}

	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//		hibernateProperties.setProperty("hibernate.cache.use_second_level_cache",
//				env.getProperty("hibernate.cache.use_second_level_cache"));
//		hibernateProperties.setProperty("hibernate.cache.use_query_cache",
//				env.getProperty("hibernate.cache.use_query_cache"));
		// hibernateProperties.setProperty("hibernate.globally_quoted_identifiers",
		// "true");
		return hibernateProperties;
	}

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("driverClassName"));
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setUsername("huydq");
		dataSource.setPassword("zaccobap2792000");
		return dataSource;
	}

//	@Bean
//	public SpringLiquibase liquibase() {
//		SpringLiquibase liquibase = new SpringLiquibase();
//		liquibase.setChangeLog("classpath:db-diff-changelog.xml");
//		liquibase.setDataSource(dataSource());
//		return liquibase;
//	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();

		mailSenderImpl.setHost("smtp.gmail.com");
		mailSenderImpl.setPort(587);
		mailSenderImpl.setProtocol("smtp");
		mailSenderImpl.setUsername("duongquanghuy2792000@gmail.com");
		mailSenderImpl.setPassword("zaccobap2792000");

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.debug", "true");
		javaMailProperties.put("mail.smtp.ssl.trust", "*");
		javaMailProperties.put("mail.smtp.host", "smtp.gmail.com");
		javaMailProperties.put("mail.smtp.port", "587");
		javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");

		mailSenderImpl.setJavaMailProperties(javaMailProperties);

		return mailSenderImpl;
	}

	@Bean(name = "multipartResolver")
	public MultipartResolver commomMultipartResolver() {
		CommonsMultipartResolver commonMultipartResolver = new CommonsMultipartResolver();
		commonMultipartResolver.setMaxUploadSize(-1);
		return commonMultipartResolver;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
