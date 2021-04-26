package org.johoco.depinsight.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;

@Configuration
@EnableArangoRepositories(basePackages = "org.johoco.depinsight.repository")
@EntityScan(basePackages = "org.johoco.depinsight.domain")
public class RepositoryConfig implements ArangoConfiguration {

	// from example
	@Override
	public ArangoDB.Builder arango() {
		return new ArangoDB.Builder().host("localhost", 8529).user("root").password(null);
	}

	// from example
	@Override
	public String database() {
		return "depinsight";
	}

}
