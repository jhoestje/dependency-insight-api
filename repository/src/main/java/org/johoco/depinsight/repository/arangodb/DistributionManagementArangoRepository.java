package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.DistributionManagement;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface DistributionManagementArangoRepository extends ArangoRepository<DistributionManagement, String> {

	// @Query("MATCH (:Actor {name:$name})-[:ACTED_IN]->(m:Movie) return m")
//	Optional<DistributionManagement> findByValue(final String value) throws Exception;

}
