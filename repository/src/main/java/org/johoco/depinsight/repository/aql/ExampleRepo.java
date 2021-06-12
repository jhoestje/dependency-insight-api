package org.johoco.depinsight.repository.aql;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
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
public class ExampleRepo extends BaseCompositeRepository {

	@Autowired
	public ExampleRepo(@Value("#{examplequeries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB) {
		super(queries, aranngoDB);
	}

	public void read() {
		try {
			String query = getQuery("name");
			Map<String, Object> bindVars = Collections.singletonMap("name", "Homer");
			ArangoCursor<BaseDocument> cursor = getArangoDb().query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println("Key: " + aDocument.getKey());
			});
		} catch (ArangoDBException e) {
			System.err.println("Failed to execute query. " + e.getMessage());
		}
	}

	public void update() {
//		myObject.addAttribute("c", "Bar");
//		try {
//		  arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject);
//		} catch (ArangoDBException e) {
//		  System.err.println("Failed to update document. " + e.getMessage());
//		}
	}

	public void delete() {

//try {
//  String query = "FOR t IN firstCollection FILTER t.name == @name "
//    + "REMOVE t IN firstCollection LET removed = OLD RETURN removed";
//  Map<String, Object> bindVars = Collections.singletonMap("name", "Homer");
//  ArangoCursor<BaseDocument> cursor = arangoDB.db(dbName).query(query, bindVars, null, BaseDocument.class);
//  cursor.forEachRemaining(aDocument -> {
//    System.out.println("Removed document " + aDocument.getKey());
//  });
//} catch (ArangoDBException e) {
//  System.err.println("Failed to execute query. " + e.getMessage());
//}
	}
}
