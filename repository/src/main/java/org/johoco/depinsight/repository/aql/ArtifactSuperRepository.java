package org.johoco.depinsight.repository.aql;

import java.util.HashMap;
import java.util.Map;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.repository.ArtifactRepository;
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
public class ArtifactSuperRepository extends BaseCompositeRepository {

	private ArtifactRepository artifactRepository;

	@Autowired
	public ArtifactSuperRepository(@Value("#{artifactqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final ArtifactRepository artifactRepository) {
		super(queries, aranngoDB);
		this.artifactRepository = artifactRepository;
	}

	public Artifact findByKey(final ArtifactKey key) {
		try {
			String query = getQuery("findByKey");
			Map<String, Object> bindVars = new HashMap<String, Object>();
			bindVars.put("groupId", key.getGroupId());
			bindVars.put("artifactId", key.getArtifactId());
			bindVars.put("version", key.getVersion());
			bindVars.put("packaging", key.getPackaging());

			ArangoCursor<Artifact> cursor = getArangoDb().query(query, bindVars, null, Artifact.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println("Key: " + aDocument.getKey());
			});
		} catch (ArangoDBException e) {
			System.err.println("Failed to execute query. " + e.getMessage());
		}
		return null;
	}

	public Artifact save(final Artifact artifact) {
		return this.artifactRepository.save(artifact);
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

	public void delete(final Artifact artifact) {
		this.artifactRepository.delete(artifact);
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
