package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfChildArtifact;
import org.johoco.depinsight.repository.arangodb.OfChildArtifactArangoRepository;
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
public class OfChildArtifactRepository
		extends BaseCompositeRepository<OfChildArtifact, OfChildArtifactArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfChildArtifactRepository.class);

	@Autowired
	public OfChildArtifactRepository(@Value("#{ofchildartifactqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfChildArtifactArangoRepository ofChildArtifactArangoRepository) {
		super(queries, aranngoDB, ofChildArtifactArangoRepository);
	}

	public Optional<OfChildArtifact> getByVertexIds(final OfChildArtifact ofChildArtifact) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("artifactIdParent", ofChildArtifact.getParent().getArangoId());
		bindVars.put("artifactIdChild", ofChildArtifact.getChild().getArangoId());

		ArangoCursor<OfChildArtifact> cursor = getArangoDb().query(query, bindVars, null, OfChildArtifact.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfChildArtifact save(final OfChildArtifact ofChildArtifact) {
		LOGR.debug("Saving OfChildArtifact id {} - from {} to {}:  ", ofChildArtifact.getArangoKey(),
				ofChildArtifact.getChild(), ofChildArtifact.getParent());
		return this.getRepository().save(ofChildArtifact);
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

	public void delete(final OfChildArtifact ofChildArtifact) {
		this.getRepository().delete(ofChildArtifact);
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
