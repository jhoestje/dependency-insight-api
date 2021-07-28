package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfScm;
import org.johoco.depinsight.repository.arangodb.OfScmArangoRepository;
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
public class OfScmRepository extends BaseCompositeRepository<OfScm, OfScmArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfScmRepository.class);

	@Autowired
	public OfScmRepository(@Value("#{ofdeveloperqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfScmArangoRepository ofScmArangoRepository) {
		super(queries, aranngoDB, ofScmArangoRepository);
	}

	public Optional<OfScm> getByVertexIds(final OfScm ofScm) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("devVertexId", ofScm.getScm().getArangoId());
		bindVars.put("artifactVertexId", ofScm.getArtifact().getArangoId());

		ArangoCursor<OfScm> cursor = getArangoDb().query(query, bindVars, null, OfScm.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfScm save(final OfScm ofScm) {
		LOGR.debug("Saving OfScm id {} - from {} to {}:  ", ofScm.getArangoKey(), ofScm.getArtifact(), ofScm.getScm());
		return this.getRepository().save(ofScm);
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

	public void delete(final OfScm ofScm) {
		this.getRepository().delete(ofScm);
	}

//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}

}
