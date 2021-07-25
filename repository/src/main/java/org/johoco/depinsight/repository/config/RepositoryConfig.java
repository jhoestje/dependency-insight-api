package org.johoco.depinsight.repository.config;

import java.util.ArrayList;
import java.util.Set;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.CiManagement;
import org.johoco.depinsight.domain.Classifier;
import org.johoco.depinsight.domain.Contributor;
import org.johoco.depinsight.domain.Developer;
import org.johoco.depinsight.domain.DistributionManagement;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.IssueManagement;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.License;
import org.johoco.depinsight.domain.MailingList;
import org.johoco.depinsight.domain.Organization;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.Prerequisite;
import org.johoco.depinsight.domain.Repository;
import org.johoco.depinsight.domain.Scm;
import org.johoco.depinsight.domain.Version;
import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.Dependency;
import org.johoco.depinsight.domain.relationship.OfArtifactId;
import org.johoco.depinsight.domain.relationship.OfChildArtifact;
import org.johoco.depinsight.domain.relationship.OfClassifier;
import org.johoco.depinsight.domain.relationship.OfGavp;
import org.johoco.depinsight.domain.relationship.OfGroupId;
import org.johoco.depinsight.domain.relationship.OfLanguage;
import org.johoco.depinsight.domain.relationship.OfVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.ArangoGraph;
import com.arangodb.entity.EdgeDefinition;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import com.arangodb.springframework.core.ArangoOperations;
import com.arangodb.springframework.core.template.ArangoTemplate;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Configuration
//@ComponentScan(basePackages = "org.johoco.depinsight.repository")
@EnableArangoRepositories(basePackages = "org.johoco.depinsight.repository")
@EntityScan(basePackages = "org.johoco.depinsight.domain")
@ImportResource("classpath:database.queries.spring.xml")
public class RepositoryConfig implements ArangoConfiguration {

	private final static Logger LOG = LoggerFactory.getLogger(RepositoryConfig.class);

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

	/**
	 * Staring from the Top of the graph to the bottom via Edges.
	 * 
	 * @param graph - the graph to add Edges to
	 */
	private void buildEdgeDefinitions(final ArangoGraph graph) {
		final Set<String> names = Set.copyOf(graph.getEdgeDefinitions());

		// GroupId > Language
		if (!names.contains(OfLanguage.getName())) {
			final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(OfLanguage.getName())
					.from(OfLanguage.getFromName()).to(OfLanguage.getToName());
			graph.addEdgeDefinition(edgeDefinition);
		}

		// ArtifactID > GroupId
		if (!names.contains(OfGroupId.getName())) {
			final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(OfGroupId.getName())
					.from(OfGroupId.getFromName()).to(OfGroupId.getToName());
			graph.addEdgeDefinition(edgeDefinition);
		}

		// Version > ArtifactID
		if (!names.contains(OfArtifactId.getName())) {
			final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(OfArtifactId.getName())
					.from(OfArtifactId.getFromName()).to(OfArtifactId.getToName());
			graph.addEdgeDefinition(edgeDefinition);
		}

		// Packaging > Version
		if (!names.contains(OfVersion.getName())) {
			final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(OfVersion.getName())
					.from(OfVersion.getFromName()).to(OfVersion.getToName());
			graph.addEdgeDefinition(edgeDefinition);
		}

		// Classifier > Version
		if (!names.contains(OfClassifier.getName())) {
			final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(OfClassifier.getName())
					.from(OfClassifier.getFromName()).to(OfClassifier.getToName());
			graph.addEdgeDefinition(edgeDefinition);
		}

		// Artifact > Packaging (GAVP)
		if (!names.contains(OfGavp.getName())) {
			final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(OfGavp.getName())
					.from(OfGavp.getFromName()).to(OfGavp.getToName());
			graph.addEdgeDefinition(edgeDefinition);
		}

		// Child > Parent POM/artifact
		if (!names.contains(OfChildArtifact.getName())) {
			final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(OfChildArtifact.getName())
					.from(OfChildArtifact.getFromName()).to(OfChildArtifact.getToName());
			graph.addEdgeDefinition(edgeDefinition);
		}

		// Dependency > Backing Artifact

	}

	private void createGraph(final ArangoDatabase arangoDatabase) {
		ArangoGraph graph = arangoDatabase.graph(graph());

		LOG.debug(String.format("=== ArangoDB Database exists:  %b", graph.exists()));
		if (!graph.exists()) {
			arangoDatabase.createGraph(graph(), new ArrayList<EdgeDefinition>(), null);
		}

		buildEdgeDefinitions(graph);
	}

	private void createDatabase(final ArangoDatabase arangoDatabase) {
		Boolean databaseExists = arangoDatabase.exists();
		LOG.debug(String.format("=== Does ArangoDB Database exist:  %b", databaseExists.toString()));

		if (Boolean.FALSE.equals(databaseExists)) {
			try {
				if (arangoDatabase.create()) {
					LOG.debug("=== Created ArangoDB Database");
				} else {
					LOG.debug("===!!!! Did not create ArangoDB Database");
				}
			} catch (ArangoDBException adbe) {
				LOG.error("===!!!! ArangoDBException ArangoDBException ArangoDBException ArangoDBException "
						+ adbe.getErrorMessage());
				throw adbe;
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
		operations.collection(GroupId.class);
		operations.collection(ArtifactId.class);
		operations.collection(Version.class);
		operations.collection(Packaging.class);
		operations.collection(Classifier.class);
		operations.collection(Artifact.class);
		operations.collection(Dependency.class);
		operations.collection(Organization.class);
		operations.collection(License.class);

		operations.collection(Developer.class);
		operations.collection(Contributor.class);
		operations.collection(MailingList.class);
		operations.collection(Prerequisite.class);
		operations.collection(Scm.class);
		operations.collection(IssueManagement.class);
		operations.collection(CiManagement.class);
		operations.collection(DistributionManagement.class);
//		operations.collection(Dependency.class);
//		operations.collection(DependencyManagement.class);
		operations.collection(Repository.class);

	}

}
