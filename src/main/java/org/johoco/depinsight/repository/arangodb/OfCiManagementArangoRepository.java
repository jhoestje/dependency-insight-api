package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfCiManagement;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfCiManagementArangoRepository extends ArangoRepository<OfCiManagement, String> {

}
