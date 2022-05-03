package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfDistributionManagement;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfDistributionManagementArangoRepository extends ArangoRepository<OfDistributionManagement, String> {
}
