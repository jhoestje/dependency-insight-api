package org.johoco.depinsight.repository.arangodb.extended;

import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.Build;
import org.johoco.depinsight.repository.arangodb.BuildArangoRepository;
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
public class BuildRepository extends BaseCompositeRepository<Build, BuildArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(BuildRepository.class);

	@Autowired
	public BuildRepository(@Value("#{buildqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final BuildArangoRepository buildRepository) {
		super(queries, aranngoDB, buildRepository);
	}

//	/**
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public Optional<Build> get(final Build groupId) {
//		String query = getQuery("getById");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("id", groupId.getId());
//
//		ArangoCursor<Build> cursor = getArangoDb().query(query, bindVars, null, Build.class);
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
	public Optional<Build> findOne(final Build build) {
		return getRepository().findOne(Example.of(build));
	}

	public Build save(final Build build) {
		LOGR.debug("Saving Build id {} ArangoId {}:  ", build.getArangoKey(), build.getArangoId());
		return this.getRepository().save(build);
	}

	public void delete(final Build build) {
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

	public void update() {
//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}
	}

}
