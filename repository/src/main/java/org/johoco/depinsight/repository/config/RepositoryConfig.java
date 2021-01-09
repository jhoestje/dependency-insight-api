package org.johoco.depinsight.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages = "org.johoco.depinsight.repository")
@EntityScan(basePackages = "org.johoco.depinsight.domain")
public class RepositoryConfig {

//	@Bean
//	public SessionFactory sessionFactory() {
//		// with domain entity base package(s)
//		return new SessionFactory(configuration(), "org.johoco.depinsight.domain");
//	}
//
//	// @Bean
//	public org.neo4j.ogm.config.Configuration configuration() {
//		// ConfigurationSource properties = new
//		// ClasspathConfigurationSource("ogm.properties");
//		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
//				.uri("bolt://localhost:7687").build();
//		return configuration;
//	}
//
//	// @Bean
//	public Neo4jTransactionManager transactionManager() {
//		return new Neo4jTransactionManager(sessionFactory());
//	}

}
