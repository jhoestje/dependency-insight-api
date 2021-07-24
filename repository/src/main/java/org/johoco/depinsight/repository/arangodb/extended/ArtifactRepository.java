package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.repository.arangodb.ArtifactArangoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.arangodb.ArangoCursor;
import com.arangodb.springframework.core.ArangoOperations;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Repository
public class ArtifactRepository extends BaseCompositeRepository<Artifact, ArtifactArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(ArtifactRepository.class);

	@Autowired
	public ArtifactRepository(@Value("#{artifactqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final ArtifactArangoRepository artifactRepository) {
		super(queries, aranngoDB, artifactRepository);
	}

	public Optional<Artifact> getByKey(final ArtifactKey key) {
		String query = getQuery("getByKey");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("languageId", key.getLanguage());
		bindVars.put("groupIdId", key.getGroupIdValue());
		bindVars.put("artifactIdId", key.getArtifactIdValue());
		bindVars.put("versionId", key.getVersion());
		bindVars.put("packagingId", key.getPackaging());

		ArangoCursor<Artifact> cursor = getArangoDb().query(query, bindVars, null, Artifact.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
	}

	public Artifact save(final Artifact artifact) {
		LOGR.debug("Saving Artifact id {} key {}:  ", artifact.getId(), artifact.getKey());
		return this.getRepository().save(artifact);
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
		this.getRepository().delete(artifact);
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
