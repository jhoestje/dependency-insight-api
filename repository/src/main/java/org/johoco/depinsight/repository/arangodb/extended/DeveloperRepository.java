package org.johoco.depinsight.repository.arangodb.extended;

import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.Developer;
import org.johoco.depinsight.domain.key.DeveloperKey;
import org.johoco.depinsight.repository.arangodb.DeveloperArangoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

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
public class DeveloperRepository extends BaseCompositeRepository<Developer, DeveloperArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(DeveloperRepository.class);

	@Autowired
	public DeveloperRepository(@Value("#{developerqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final DeveloperArangoRepository developerRepository) {
		super(queries, aranngoDB, developerRepository);
	}

//	/**
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public Optional<Developer> get(final Developer groupId) {
//		String query = getQuery("getById");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("id", groupId.getId());
//
//		ArangoCursor<Developer> cursor = getArangoDb().query(query, bindVars, null, Developer.class);
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
//	public Optional<Developer> getByKey(final DeveloperKey key) {
////		try {
//		String query = getQuery("getByKey");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("email", key.getEmail());
//
//		ArangoCursor<Developer> cursor = getArangoDb().query(query, bindVars, null, Developer.class);
////		cursor.forEachRemaining(aDocument -> {
////			System.out.println("Key: " + aDocument.getKey());
////		});
//		// return Optional.of(cursor.next());
//		if (cursor.hasNext()) {
//			return Optional.of(cursor.next());
//		}
//		return Optional.empty();
////		} catch (ArangoDBException e) {
////			System.err.println("Failed to execute query. " + e.getMessage());
////		}
////		return Optional.empty();
//	}

	public Developer save(final Developer developer) {
		LOGR.debug("Saving Developer id {}:  ", developer.getId());
		return this.getRepository().save(developer);
	}

	public void delete(final DeveloperKey key) {
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

	public void delete(final Developer developer) {
//		this.delete(developer);
	}

	public void update() {
//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}
	}

	public Optional<Developer> findOne(Developer developer) {
		return getRepository().findOne(Example.of(developer));
	}

}
