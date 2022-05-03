package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfGroupId;
import org.johoco.depinsight.repository.arangodb.OfGroupIdArangoRepository;
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
public class OfGroupIdRepository extends BaseCompositeRepository<OfGroupId, OfGroupIdArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfGroupIdRepository.class);

	@Autowired
	public OfGroupIdRepository(@Value("#{ofgroupidqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfGroupIdArangoRepository ofGroupIdArangoRepository) {
		super(queries, aranngoDB, ofGroupIdArangoRepository);
	}

	public Iterable<OfGroupId> findAll() {
		return this.getRepository().findAll();
	}

	public Optional<OfGroupId> getByVertexIds(final OfGroupId ofGroupId) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("groupId", ofGroupId.getGroupId().getArangoId());
		bindVars.put("artifactId", ofGroupId.getArtifactId().getArangoId());

		ArangoCursor<OfGroupId> cursor = getArangoDb().query(query, bindVars, null, OfGroupId.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfGroupId save(final OfGroupId ofGroupId) {
		LOGR.debug("Saving OfGroupId id {} - from {} to {}:  ", ofGroupId.getArangoKey(), ofGroupId.getArtifactId(),
				ofGroupId.getGroupId());
		return this.getRepository().save(ofGroupId);
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

	public void delete(final OfGroupId ofGroupId) {
		this.getRepository().delete(ofGroupId);
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
