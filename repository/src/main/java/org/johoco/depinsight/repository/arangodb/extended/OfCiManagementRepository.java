package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfCiManagement;
import org.johoco.depinsight.repository.arangodb.OfCiManagementArangoRepository;
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
public class OfCiManagementRepository extends BaseCompositeRepository<OfCiManagement, OfCiManagementArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfCiManagementRepository.class);

	@Autowired
	public OfCiManagementRepository(@Value("#{ofcimanagementqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfCiManagementArangoRepository ofCiManagementArangoRepository) {
		super(queries, aranngoDB, ofCiManagementArangoRepository);
	}

	public Optional<OfCiManagement> getByVertexIds(final OfCiManagement ofCiManagement) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("ciVertexId", ofCiManagement.getCiManagement().getArangoId());
		bindVars.put("artifactVertexId", ofCiManagement.getArtifact().getArangoId());

		ArangoCursor<OfCiManagement> cursor = getArangoDb().query(query, bindVars, null, OfCiManagement.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfCiManagement save(final OfCiManagement ofCiManagement) {
		LOGR.debug("Saving OfCiManagement id {} - from {} to {}:  ", ofCiManagement.getArangoKey(),
				ofCiManagement.getArtifact(), ofCiManagement.getCiManagement());
		return this.getRepository().save(ofCiManagement);
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

	public void delete(final OfCiManagement ofCiManagement) {
		this.getRepository().delete(ofCiManagement);
	}

//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}

}
