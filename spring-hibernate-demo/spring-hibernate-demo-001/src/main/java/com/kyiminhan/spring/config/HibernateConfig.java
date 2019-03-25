package com.kyiminhan.spring.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * The Class HibernateConfig.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/03/15 </BR>
 *        spring-hibernate-demo-001 system </BR>
 *        com.kyiminhan.spring.config </BR>
 *        HibernateConfig.java </BR>
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties", "classpath:db.properties" })
@ComponentScan("com.kyiminhan.spring")
public class HibernateConfig implements WebMvcConfigurer {

	/** The mysql driver. */
	@Value("${mysql.driver}")
	private String mysqlDriver;

	/** The jdbc URL. */
	@Value("${mysql.jdbcUrl}")
	private String jdbcURL;

	/** The user name. */
	@Value("${mysql.username}")
	private String userName;

	/** The password. */
	@Value("${mysql.password}")
	private String password;

	/** The hibernte dialet. */
	@Value("${hibernate.dialet}")
	private String hibernteDialet;

	/** The hibernate show sql. */
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	/** The hibernage hbm ddl auto. */
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernageHbmDdlAuto;

	/** The hibernate lazy load. */
	@Value("${hibernate.enable_lazy_load_no_trans}")
	private String hibernateLazyLoad;

	/** The hibernate etities. */
	@Value("${hibernate.entity}")
	private String hibernateEtities;

	/** The hibernate C 3 p 0 min size. */
	@Value("${hibernate.c3p0.min_size}")
	private String hibernateC3p0MinSize;

	/** The hibernate C 3 p 0 max size. */
	@Value("${hibernate.c3p0.max_size}")
	private String hibernateC3p0MaxSize;

	/** The hibernate C 3 p 0 acquire increment. */
	@Value("${hibernate.c3p0.acquire_increment}")
	private String hibernateC3p0AcquireIncrement;

	/** The hibernate C 3 p 0 timeout. */
	@Value("${hibernate.c3p0.timeout}")
	private String hibernateC3p0Timeout;

	/** The hibernate C 3 p 0 max statements. */
	@Value("${hibernate.c3p0.max_statements}")
	private String hibernateC3p0MaxStatements;

	/** The hibernate connection pool size. */
	@Value("${hibernate.connection.pool_size}")
	private String hibernateConnectionPoolSize;

	/** The hibernate jdbc batch size. */
	@Value("${hibernate.jdbc.batch_size}")
	private String hibernateJdbcBatchSize;

	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 * @throws PropertyVetoException the property veto exception
	 */
	@Bean
	public DataSource getDataSource() throws PropertyVetoException {

		final ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(this.mysqlDriver);
		dataSource.setJdbcUrl(this.jdbcURL);
		dataSource.setUser(this.userName);
		dataSource.setPassword(this.password);
		return dataSource;

	}

	/**
	 * Entity manager factory.
	 *
	 * @return LocalContainerEntityManagerFactoryBean
	 * @throws PropertyVetoException the property veto exception
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() throws PropertyVetoException {
		final LocalSessionFactoryBean lcemf = new LocalSessionFactoryBean();
		lcemf.setDataSource(this.getDataSource());
		lcemf.setPackagesToScan(new String[] { this.hibernateEtities });
		lcemf.setHibernateProperties(this.additionalProperties());
		return lcemf;
	}

	/**
	 * Transaction manager.
	 *
	 * @param emf the emf
	 * @return PlatformTransactionManager
	 * @throws PropertyVetoException
	 */
	@Bean
	public HibernateTransactionManager transactionManager() throws PropertyVetoException {
		final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(this.sessionFactoryBean().getObject());
		return transactionManager;
	}

	/**
	 * Exception translation.
	 *
	 * @return PersistenceExceptionTranslationPostProcessor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * Additional properties.
	 *
	 * @return Properties
	 */
	private Properties additionalProperties() {
		final Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, this.hibernteDialet);
		properties.put(AvailableSettings.SHOW_SQL, this.hibernateShowSql);
		properties.put(AvailableSettings.HBM2DDL_AUTO, this.hibernageHbmDdlAuto);
		properties.put(AvailableSettings.ENABLE_LAZY_LOAD_NO_TRANS, this.hibernateLazyLoad);
		// c3p0 connection Configuration
		properties.put(AvailableSettings.C3P0_MIN_SIZE, this.hibernateC3p0MinSize);
		properties.put(AvailableSettings.C3P0_MAX_SIZE, this.hibernateC3p0MaxSize);
		properties.put(AvailableSettings.C3P0_ACQUIRE_INCREMENT, this.hibernateC3p0AcquireIncrement);
		properties.put(AvailableSettings.C3P0_TIMEOUT, this.hibernateC3p0Timeout);
		properties.put(AvailableSettings.C3P0_MAX_STATEMENTS, this.hibernateC3p0MaxStatements);

		properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, this.hibernateJdbcBatchSize);
		properties.put(AvailableSettings.POOL_SIZE, this.hibernateConnectionPoolSize);
		return properties;
	}
}