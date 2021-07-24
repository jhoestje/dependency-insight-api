package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Version;
import org.johoco.depinsight.domain.key.GroupIdKey;
import org.johoco.depinsight.domain.key.VersionKey;
import org.johoco.depinsight.repository.arangodb.VersionArangoRepository;
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
public class VersionRepository extends BaseCompositeRepository<Version, VersionArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(VersionRepository.class);

	@Autowired
	public VersionRepository(@Value("#{versionqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final VersionArangoRepository versionArangoRepository) {
		super(queries, aranngoDB, versionArangoRepository);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Optional<Version> getByKey(final VersionKey key) {
//		try {
		String query = getQuery("getByKey");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("language", key.getLanguage());
		bindVars.put("groupId", key.getGroupIdValue());
		bindVars.put("artifactId", key.getArtifactIdValue());
		bindVars.put("versionId", key.getVersionValue());

		ArangoCursor<Version> cursor = getArangoDb().query(query, bindVars, null, Version.class);
//		cursor.forEachRemaining(aDocument -> {
//			System.out.println("Key: " + aDocument.getKey());
//		});
//		return Optional.of(cursor.next());
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return Optional.empty();
	}

	public Version save(final Version version) {
		LOGR.debug("Saving ArtifactId id {} - from {} to {}:  ", version.getId(), version.getKey());
		return this.getRepository().save(version);
	}

	public void delete(final GroupIdKey key) {
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

	public void delete(final GroupId groupId) {
		this.delete(groupId.getKey());
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
