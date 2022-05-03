package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfLicense;
import org.johoco.depinsight.repository.arangodb.OfLicenseArangoRepository;
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
public class OfLicenseRepository extends BaseCompositeRepository<OfLicense, OfLicenseArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OfLicenseRepository.class);

	@Autowired
	public OfLicenseRepository(@Value("#{oflicensequeries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OfLicenseArangoRepository ofLicenseArangoRepository) {
		super(queries, aranngoDB, ofLicenseArangoRepository);
	}

	public Optional<OfLicense> getByVertexIds(final OfLicense ofLicense) {
//		try {
		String query = getQuery("getByVertexIds");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("licVertexId", ofLicense.getLicense().getArangoId());
		bindVars.put("artifactVertexId", ofLicense.getArtifact().getArangoId());

		ArangoCursor<OfLicense> cursor = getArangoDb().query(query, bindVars, null, OfLicense.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return null;
	}

	public OfLicense save(final OfLicense ofLicense) {
		LOGR.debug("Saving OfLicense id {} - from {} to {}:  ", ofLicense.getArangoKey(), ofLicense.getArtifact(),
				ofLicense.getLicense());
		return this.getRepository().save(ofLicense);
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

	public void delete(final OfLicense ofLicense) {
		this.getRepository().delete(ofLicense);
	}

//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}

}
