package org.johoco.depinsight.repository.config;

import java.util.ArrayList;
import java.util.Collection;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.relationship.LanguageType;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.EdgeDefinition;
import com.arangodb.entity.GraphEntity;
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
		// ArangoDBImpl
		ArangoDB arangoDB = arango().build();

		ArangoOperations operations = new ArangoTemplate(arangoDB, database(), arangoConverter(), resolverFactory());
		ArangoDatabase arangoDatabase = arangoDB.db(database());

		createDatabase(arangoDatabase);

//		CollectionEntity myArangoCollection = arangoDatabase.createCollection("collectionName");

		final Collection<EdgeDefinition> edgeDefinitions = new ArrayList<>();
		final EdgeDefinition edgeDefinition = new EdgeDefinition().collection("EDGE_COLLECTION_NAME")
				.from("VERTEXT_COLLECTION_NAME").to("VERTEXT_COLLECTION_NAME");
		edgeDefinitions.add(edgeDefinition);
		arangoDatabase.createGraph("GRAPH_NAME", edgeDefinitions, null);

		// check if graph is created
		Collection<GraphEntity> graphs = arangoDatabase.getGraphs();
		graphs.isEmpty();

		setupDatabase(operations);

		return operations;
	}

	private void createDatabase(final ArangoDatabase arangoDatabase) {
		Boolean databaseExists = arangoDatabase.exists();
		System.out.println("=== Does ArangoDB Database exist:  " + databaseExists.toString());

		if (Boolean.FALSE.equals(databaseExists)) {
			System.out.println("=== ArangoDB Database does not exist");
			try {

				if (arangoDatabase.create()) {
					System.out.println("=== Created ArangoDB Database");
				} else {
					System.out.println("===!!!! Did not create ArangoDB Database");
				}
			} catch (ArangoDBException adbe) {
				System.out.println("===!!!! ArangoDBException ArangoDBException ArangoDBException ArangoDBException "
						+ adbe.getErrorMessage());
			}
		}
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
