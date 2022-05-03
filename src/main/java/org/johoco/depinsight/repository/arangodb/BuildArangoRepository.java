package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.Build;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface BuildArangoRepository extends ArangoRepository<Build, String> {

	// @Query("MATCH (:Actor {name:$name})-[:ACTED_IN]->(m:Movie) return m")
	// Optional<Build> findByValue(final String value) throws Exception;

}
