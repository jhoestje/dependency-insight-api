package org.johoco.depinsight.repository.arangodb;

import java.util.Optional;

import org.johoco.depinsight.domain.Packaging;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface PackagingArangoRepository extends ArangoRepository<Packaging, String> {

	// @Query("MATCH (:Actor {name:$name})-[:ACTED_IN]->(m:Movie) return m")
	Optional<Packaging> findByValue(final String value);

}
