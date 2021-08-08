package org.johoco.depinsight.repository.arangodb.extended;

import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.IssueManagement;
import org.johoco.depinsight.domain.key.IssueManagementKey;
import org.johoco.depinsight.repository.arangodb.IssueManagementArangoRepository;
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
public class IssueManagementRepository
		extends BaseCompositeRepository<IssueManagement, IssueManagementArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(IssueManagementRepository.class);

	@Autowired
	public IssueManagementRepository(@Value("#{issuemanagementqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final IssueManagementArangoRepository issueManagementRepository) {
		super(queries, aranngoDB, issueManagementRepository);
	}

//	/**
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public Optional<IssueManagement> get(final IssueManagement groupId) {
//		String query = getQuery("getById");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("id", groupId.getId());
//
//		ArangoCursor<IssueManagement> cursor = getArangoDb().query(query, bindVars, null, IssueManagement.class);
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
//	public Optional<IssueManagement> getByKey(final IssueManagementKey key) {
////		try {
//		String query = getQuery("getByKey");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("email", key.getUrl());
//
//		ArangoCursor<IssueManagement> cursor = getArangoDb().query(query, bindVars, null, IssueManagement.class);
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

	public Optional<IssueManagement> findOne(final IssueManagement issueManagement) {
		return getRepository().findOne(Example.of(issueManagement));
	}

	public IssueManagement save(final IssueManagement issueManagement) {
		LOGR.debug("Saving id {} ArangoId {}:  ", issueManagement.getArangoKey(), issueManagement.getArangoId());
		return this.getRepository().save(issueManagement);
	}

	public void delete(final IssueManagementKey key) {
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

	public void delete(final IssueManagement issueManagement) {
		this.delete(issueManagement.getKey());
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
