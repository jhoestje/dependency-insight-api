package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfDeveloper;
import org.johoco.depinsight.repository.arangodb.OfDeveloperArangoRepository;
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
public class OfDeveloperRepository extends BaseCompositeRepository<OfDeveloper, OfDeveloperArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfDeveloperRepository.class);

	@Autowired
	public OfDeveloperRepository(@Value("#{ofdeveloperqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfDeveloperArangoRepository ofDeveloperArangoRepository) {
		super(queries, aranngoDB, ofDeveloperArangoRepository);
	}

	public Optional<OfDeveloper> getByVertexIds(final OfDeveloper ofDeveloper) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("devVertexId", ofDeveloper.getDeveloper().getArangoId());
		bindVars.put("artifactVertexId", ofDeveloper.getArtifact().getArangoId());

		ArangoCursor<OfDeveloper> cursor = getArangoDb().query(query, bindVars, null, OfDeveloper.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfDeveloper save(final OfDeveloper ofDeveloper) {
		LOGR.debug("Saving OfDeveloper id {} - from {} to {}:  ", ofDeveloper.getArangoKey(), ofDeveloper.getArtifact(),
				ofDeveloper.getDeveloper());
		return this.getRepository().save(ofDeveloper);
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

	public void delete(final OfDeveloper ofDeveloper) {
		this.getRepository().delete(ofDeveloper);
	}

//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}

}
