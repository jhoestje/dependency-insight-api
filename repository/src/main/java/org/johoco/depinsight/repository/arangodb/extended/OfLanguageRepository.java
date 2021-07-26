package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfLanguage;
import org.johoco.depinsight.repository.arangodb.OfLanguageArangoRepository;
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
public class OfLanguageRepository extends BaseCompositeRepository<OfLanguage, OfLanguageArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfLanguageRepository.class);

	@Autowired
	public OfLanguageRepository(@Value("#{oflanguagequeries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfLanguageArangoRepository ofLanguageArangoRepository) {
		super(queries, aranngoDB, ofLanguageArangoRepository);
	}

	public Iterable<OfLanguage> findAll() {
		return this.getRepository().findAll();
	}

	public Optional<OfLanguage> getByVertexIds(final OfLanguage ofLanguage) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("languageId", ofLanguage.getLanguage().getArangoId());
		bindVars.put("groupId", ofLanguage.getGroupId().getArangoId());

		ArangoCursor<OfLanguage> cursor = getArangoDb().query(query, bindVars, null, OfLanguage.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfLanguage save(final OfLanguage ofLanguage) {
		LOGR.debug("Saving ofLanguage id {} - from {} to {}:  ", ofLanguage.getArangoKey(), ofLanguage.getGroupId(),
				ofLanguage.getLanguage());
		return this.getRepository().save(ofLanguage);
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

	public void delete(final OfLanguage ofLanguage) {
		this.getRepository().delete(ofLanguage);
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
