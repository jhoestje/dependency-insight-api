package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfContributor;
import org.johoco.depinsight.repository.arangodb.OfContributorArangoRepository;
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
public class OfContributorRepository extends BaseCompositeRepository<OfContributor, OfContributorArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfContributorRepository.class);

	@Autowired
	public OfContributorRepository(@Value("#{ofcontributorqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfContributorArangoRepository ofContributorArangoRepository) {
		super(queries, aranngoDB, ofContributorArangoRepository);
	}

	public Optional<OfContributor> getByVertexIds(final OfContributor ofContributor) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("conVertexId", ofContributor.getContributor().getArangoId());
		bindVars.put("artifactVertexId", ofContributor.getArtifact().getArangoId());

		ArangoCursor<OfContributor> cursor = getArangoDb().query(query, bindVars, null, OfContributor.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfContributor save(final OfContributor ofContributor) {
		LOGR.debug("Saving OfContributor id {} - from {} to {}:  ", ofContributor.getArangoKey(),
				ofContributor.getArtifact(), ofContributor.getContributor());
		return this.getRepository().save(ofContributor);
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

	public void delete(final OfContributor ofContributor) {
		this.getRepository().delete(ofContributor);
	}

//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}

}
