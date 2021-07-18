package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.key.ArtifactIdKey;
import org.johoco.depinsight.domain.key.GroupIdKey;
import org.johoco.depinsight.repository.arangodb.ArtifactIdArangoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDBException;
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
public class ArtifactIdRepository extends BaseCompositeRepository<ArtifactId, ArtifactIdArangoRepository> {

	@Autowired
	public ArtifactIdRepository(@Value("#{artifactidqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final ArtifactIdArangoRepository artifactdIdRepository) {
		super(queries, aranngoDB, artifactdIdRepository);
	}

	/**
	 * Return the found Optional<GroupId> or let the {@link NoSuchElementException}
	 * or {@link ArangoDBException} bubble up.
	 * 
	 * @param key
	 * @return
	 */
	public Optional<ArtifactId> findByKey(final ArtifactIdKey key) {
//		try {
		String query = getQuery("findByKey");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("language", key.getLanguage());
		bindVars.put("groupId", key.getGroupIdValue());
		bindVars.put("artifactId", key.getArtifactIdValue());

		ArangoCursor<ArtifactId> cursor = getArangoDb().query(query, bindVars, null, ArtifactId.class);
//		cursor.forEachRemaining(aDocument -> {
//			System.out.println("Key: " + aDocument.getKey());
//		});
		return Optional.of(cursor.next());
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return Optional.empty();
	}

	public ArtifactId save(final ArtifactId artifactId) {
//		super.preSave(groupId);
		return this.getRepository().save(artifactId);
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
