package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.Scm;
import org.johoco.depinsight.domain.key.ScmKey;
import org.johoco.depinsight.repository.arangodb.ScmArangoRepository;
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
public class ScmRepository extends BaseCompositeRepository<Scm, ScmArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(ScmRepository.class);

	@Autowired
	public ScmRepository(@Value("#{scmqueries}") final Map<String, String> queries, final ArangoOperations aranngoDB,
			final ScmArangoRepository scmRepository) {
		super(queries, aranngoDB, scmRepository);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Optional<Scm> getByKey(final ScmKey key) {
		String query = getQuery("getByKey");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("url", key.getUrl());

		ArangoCursor<Scm> cursor = getArangoDb().query(query, bindVars, null, Scm.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
	}

	public Scm save(final Scm scm) {
		LOGR.debug("Saving Scm id {} - from {} to {}:  ", scm.getArangoId(), scm.getKey());
		return this.getRepository().save(scm);
	}

	public void delete(final ScmKey key) {
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

	public void delete(final Scm scm) {
		this.delete(scm.getKey());
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
