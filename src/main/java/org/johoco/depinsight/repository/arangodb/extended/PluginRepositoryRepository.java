package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.PluginRepository;
import org.johoco.depinsight.domain.key.RepositoryKey;
import org.johoco.depinsight.repository.arangodb.PluginRepositoryArangoRepository;
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
public class PluginRepositoryRepository
		extends BaseCompositeRepository<PluginRepository, PluginRepositoryArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(PluginRepositoryRepository.class);

	@Autowired
	public PluginRepositoryRepository(@Value("#{repositoryqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final PluginRepositoryArangoRepository pluginRepository) {
		super(queries, aranngoDB, pluginRepository);
	}

//	/**
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public Optional<PluginRepository> get(final PluginRepository groupId) {
//		String query = getQuery("getById");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("id", groupId.getId());
//
//		ArangoCursor<PluginRepository> cursor = getArangoDb().query(query, bindVars, null, PluginRepository.class);
//		if (cursor.hasNext()) {
//			return Optional.of(cursor.next());
//		}
//		return Optional.empty();
//	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Optional<PluginRepository> getByKey(final RepositoryKey key) {
//		try {
		String query = getQuery("getByKey");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("email", key.getUrl());

		ArangoCursor<PluginRepository> cursor = getArangoDb().query(query, bindVars, null, PluginRepository.class);
//		cursor.forEachRemaining(aDocument -> {
//			System.out.println("Key: " + aDocument.getKey());
//		});
		// return Optional.of(cursor.next());
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return Optional.empty();
	}

	public PluginRepository save(final PluginRepository repository) {
		LOGR.debug("Saving PluginRepository id {} - from {} to {}:  ", repository.getKey().getUrl(),
				repository.getKey());
		return this.getRepository().save(repository);
	}

	public void delete(final RepositoryKey key) {
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

	public void delete(final PluginRepository repository) {
		this.delete(repository.getKey());
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
