package org.johoco.depinsight.repository.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.relationship.OfLanguage;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.ArangoGraph;
import com.arangodb.entity.EdgeDefinition;
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

	public String graph() {
		return "manifest";
	}

	@Override
	@Bean
	public ArangoOperations arangoTemplate() throws Exception {
		// ArangoDBImpl
		ArangoDB arangoDB = arango().build();

		ArangoOperations operations = new ArangoTemplate(arangoDB, database(), arangoConverter(), resolverFactory());
		ArangoDatabase arangoDatabase = arangoDB.db(database());

		createDatabase(arangoDatabase);

		setupDatabase(operations);

		createGraph(arangoDatabase);

		return operations;
	}

	private Collection<EdgeDefinition> buildEdgeDefinitions(final ArangoGraph graph) {
		final Set<String> names = Set.copyOf(graph.getEdgeDefinitions());

		final Collection<EdgeDefinition> newEdgeDefinitions = new ArrayList<>();

		if (!names.contains(OfLanguage.getName())) {
			final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(OfLanguage.getName())
					.from(OfLanguage.getFromName()).to(OfLanguage.getToName());
			graph.addEdgeDefinition(edgeDefinition);
		}

		return newEdgeDefinitions;
	}

	private void createGraph(final ArangoDatabase arangoDatabase) {
		ArangoGraph graph = arangoDatabase.graph(graph());

		if (!graph.exists()) {
			arangoDatabase.createGraph(graph(), new ArrayList<EdgeDefinition>(), null);
		}

		buildEdgeDefinitions(graph);
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
	 * Create the Collections if they don't already exist. They may or may not be
	 * part of a graph.
	 * 
	 * @param operations
	 */
	public void setupDatabase(final ArangoOperations operations) {

		operations.collection(Language.class);
		operations.collection(OfLanguage.class);
		operations.collection(GroupId.class);
	}

}
