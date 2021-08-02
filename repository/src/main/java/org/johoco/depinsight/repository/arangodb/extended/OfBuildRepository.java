package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.relationship.OfBuild;
import org.johoco.depinsight.repository.arangodb.OfBuildArangoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.arangodb.ArangoCursor;
import com.arangodb.springframework.core.ArangoOperations;

/**
 * 
 * Using AQL literal queries instead of @Query annotation on the method in order
 * to be able to use the same query in the AQL query runner.
 * 
 * @author John Hoestje
 *
 */
@Repository
public class OfBuildRepository extends BaseCompositeRepository<OfBuild, OfBuildArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfBuildRepository.class);

	@Autowired
	public OfBuildRepository(@Value("#{ofcontributorqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfBuildArangoRepository ofBuildArangoRepository) {
		super(queries, aranngoDB, ofBuildArangoRepository);
	}

	public Optional<OfBuild> getByVertexIds(final OfBuild ofBuild) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("conVertexId", ofBuild.getBuild().getArangoId());
		bindVars.put("artifactVertexId", ofBuild.getArtifact().getArangoId());

		ArangoCursor<OfBuild> cursor = getArangoDb().query(query, bindVars, null, OfBuild.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfBuild save(final OfBuild ofBuild) {
		LOGR.debug("Saving OfBuild id {} - from {} to {}:  ", ofBuild.getArangoKey(), ofBuild.getArtifact(),
				ofBuild.getBuild());
		return this.getRepository().save(ofBuild);
	}

	public void delete(final OfBuild ofBuild) {
		this.getRepository().delete(ofBuild);
	}

//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}

}
