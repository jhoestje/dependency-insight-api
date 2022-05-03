package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.Repository;
import org.johoco.depinsight.domain.key.RepositoryKey;
import org.johoco.depinsight.repository.arangodb.RepositoryArangoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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
@org.springframework.stereotype.Repository
public class RepositoryRepository extends BaseCompositeRepository<Repository, RepositoryArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(RepositoryRepository.class);

	@Autowired
	public RepositoryRepository(@Value("#{repositoryqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final RepositoryArangoRepository repoRepository) {
		super(queries, aranngoDB, repoRepository);
	}

//	/**
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public Optional<Repository> get(final Repository groupId) {
//		String query = getQuery("getById");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("id", groupId.getId());
//
//		ArangoCursor<Repository> cursor = getArangoDb().query(query, bindVars, null, Repository.class);
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
	public Optional<Repository> getByKey(final RepositoryKey key) {
//		try {
		String query = getQuery("getByKey");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("url", key.getUrl());

		ArangoCursor<Repository> cursor = getArangoDb().query(query, bindVars, null, Repository.class);
		if (LOGR.isDebugEnabled()) {
			cursor.forEachRemaining(entity -> {
				LOGR.debug("Found byKey: " + entity.getKey());
			});
		}

		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
//		} catch (ArangoDBException e) {
//			System.err.println("Failed to execute query. " + e.getMessage());
//		}
//		return Optional.empty();
	}

	public Repository save(final Repository repository) {
		LOGR.debug("Saving Repository id {} - from {} to {}:  ", repository.getKey().getUrl(), repository.getKey());
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

	public void delete(final Repository repository) {
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
