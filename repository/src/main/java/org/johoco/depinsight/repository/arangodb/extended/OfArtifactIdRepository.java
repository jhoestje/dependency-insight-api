package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfArtifactId;
import org.johoco.depinsight.repository.arangodb.OfArtifactIdArangoRepository;
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
public class OfArtifactIdRepository extends BaseCompositeRepository<OfArtifactId, OfArtifactIdArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfArtifactIdRepository.class);

	@Autowired
	public OfArtifactIdRepository(@Value("#{ofartifactidqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfArtifactIdArangoRepository ofArtifactIdArangoRepository) {
		super(queries, aranngoDB, ofArtifactIdArangoRepository);
	}

	public Iterable<OfArtifactId> findAll() {
		return this.getRepository().findAll();
	}

	public Optional<OfArtifactId> getByVertexIds(final OfArtifactId ofArtifactId) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("artifactId", ofArtifactId.getArtifactId().getArangoId());
		bindVars.put("versionId", ofArtifactId.getVersion().getArangoId());

		ArangoCursor<OfArtifactId> cursor = getArangoDb().query(query, bindVars, null, OfArtifactId.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfArtifactId save(final OfArtifactId ofArtifactId) {
		LOGR.debug("Saving OfArtifactId id {} - from {} to {}:  ", ofArtifactId.getArangoKey(),
				ofArtifactId.getVersion(), ofArtifactId.getArtifactId());
		return this.getRepository().save(ofArtifactId);
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

	public void delete(final OfArtifactId ofArtifactId) {
		this.getRepository().delete(ofArtifactId);
	}

	public void update() {
//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}
	}

}
