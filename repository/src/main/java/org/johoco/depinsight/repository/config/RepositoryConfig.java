package org.johoco.depinsight.repository.config;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.relationship.LanguageType;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import com.arangodb.springframework.core.ArangoOperations;
import com.arangodb.springframework.core.template.ArangoTemplate;

@Configuration
//@ComponentScan(basePackages = "org.johoco.depinsight.repository")
@EnableArangoRepositories(basePackages = "org.johoco.depinsight.repository")
@EntityScan(basePackages = "org.johoco.depinsight.domain")
public class RepositoryConfig implements ArangoConfiguration {

	// from example
	@Override
	public ArangoDB.Builder arango() {
		return new ArangoDB.Builder().host("localhost", 8529).user("root").password("rootpassword");
	}

	// to load arangodb.properties
//	  @Override
//	  public ArangoDB.Builder arango() {
//	    return new ArangoDB.Builder();
//	  }

	// from example
	@Override
	public String database() {
		return "depinsight";
	}

	@Override
	@Bean
	public ArangoOperations arangoTemplate() throws Exception {
		ArangoOperations operations = new ArangoTemplate(arango().build(), database(), arangoConverter(),
				resolverFactory());

		setupDatabase(operations);

		return operations;
	}

	/**
	 * Create the Collections if they don't already exist.
	 * 
	 * @param operations
	 */
	public void setupDatabase(final ArangoOperations operations) {
		operations.collection(Language.class);
		operations.collection(LanguageType.class);
		operations.collection(GroupId.class);
	}

//	@Resource
//	public void setupDatabase(ArangoMappingContext arangoContext) {
////		boolean exists = template.exists("some-id", MyObject.class)
//
//		Collection<DefaultArangoPersistentEntity<?>> entities = arangoContext.getPersistentEntities();
//		System.out.println(entities.size());
//	}

}
