package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfDistributionManagement;
import org.johoco.depinsight.repository.arangodb.OfDistributionManagementArangoRepository;
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
public class OfDistributionManagementRepository
		extends BaseCompositeRepository<OfDistributionManagement, OfDistributionManagementArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfDistributionManagementRepository.class);

	@Autowired
	public OfDistributionManagementRepository(@Value("#{ofcontributorqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB,
			final OfDistributionManagementArangoRepository ofDistributionManagementArangoRepository) {
		super(queries, aranngoDB, ofDistributionManagementArangoRepository);
	}

	public Optional<OfDistributionManagement> getByVertexIds(final OfDistributionManagement ofDistributionManagement) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("conVertexId", ofDistributionManagement.getDistributionManagement().getArangoId());
		bindVars.put("artifactVertexId", ofDistributionManagement.getArtifact().getArangoId());

		ArangoCursor<OfDistributionManagement> cursor = getArangoDb().query(query, bindVars, null,
				OfDistributionManagement.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfDistributionManagement save(final OfDistributionManagement ofDistributionManagement) {
		LOGR.debug("Saving OfDistributionManagement id {} - from {} to {}:  ", ofDistributionManagement.getArangoKey(),
				ofDistributionManagement.getArtifact(), ofDistributionManagement.getDistributionManagement());
		return this.getRepository().save(ofDistributionManagement);
	}

	public void delete(final ArtifactKey key) {
		// try {
		// String query = "FOR t IN firstCollection FILTER t.name == @name "
//	    + "REMOVE t IN firstCollection LET removed = OLD RETURN removed";
		// Map<String, Object> bindVars = Collections.singletonMap("name", "Homer");
		// ArangoCursor<BaseDocument> cursor = arangoDB.db(dbName).query(query,
		// bindVars, null, BaseDocument.class);
		// cursor.forEachRemaining(aDocument -> {
//	    System.out.println("Removed document " + aDocument.getKey());
		// });
		// } catch (ArangoDBException e) {
		// System.err.println("Failed to execute query. " + e.getMessage());
		// }
	}

	public void delete(final OfDistributionManagement ofDistributionManagement) {
		this.getRepository().delete(ofDistributionManagement);
	}

//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}

}
