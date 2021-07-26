package org.johoco.depinsight.repository.arangodb.extended;

import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.Contributor;
import org.johoco.depinsight.repository.arangodb.ContributorArangoRepository;
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
public class ContributorRepository extends BaseCompositeRepository<Contributor, ContributorArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(ContributorRepository.class);

	@Autowired
	public ContributorRepository(@Value("#{contributorqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final ContributorArangoRepository groupdIdRepository) {
		super(queries, aranngoDB, groupdIdRepository);
	}

//	/**
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public Optional<Contributor> get(final Contributor groupId) {
//		String query = getQuery("getById");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("id", groupId.getId());
//
//		ArangoCursor<Contributor> cursor = getArangoDb().query(query, bindVars, null, Contributor.class);
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
	public Optional<Contributor> findOne(final Contributor contributor) {
		return getRepository().findOne(Example.of(contributor));
	}

	public Contributor save(final Contributor contributor) {
		LOGR.debug("Saving Contributor id {} ArangoId {}:  ", contributor.getArangoKey(), contributor.getArangoId());
		return this.getRepository().save(contributor);
	}

	public void delete(final Contributor contributor) {
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
