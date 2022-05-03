package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.CiManagement;
import org.johoco.depinsight.domain.key.CiManagementKey;
import org.johoco.depinsight.repository.arangodb.CiManagementArangoRepository;
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
public class CiManagementRepository extends BaseCompositeRepository<CiManagement, CiManagementArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(CiManagementRepository.class);

	@Autowired
	public CiManagementRepository(@Value("#{cimanagementqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final CiManagementArangoRepository ciManagementRepository) {
		super(queries, aranngoDB, ciManagementRepository);
	}

//	/**
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public Optional<CiManagement> get(final CiManagement groupId) {
//		String query = getQuery("getById");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("id", groupId.getId());
//
//		ArangoCursor<CiManagement> cursor = getArangoDb().query(query, bindVars, null, CiManagement.class);
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
	public Optional<CiManagement> getByKey(final CiManagementKey key) {
//		try {
		String query = getQuery("getByKey");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("email", key.getUrl());

		ArangoCursor<CiManagement> cursor = getArangoDb().query(query, bindVars, null, CiManagement.class);
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

	public CiManagement save(final CiManagement ciManagement) {
		LOGR.debug("Saving CiManagement id {} - from {} to {}:  ", ciManagement.getKey().getUrl(),
				ciManagement.getKey());
		return this.getRepository().save(ciManagement);
	}

	public void delete(final CiManagementKey key) {
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

	public void delete(final CiManagement ciManagement) {
		this.delete(ciManagement.getKey());
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
