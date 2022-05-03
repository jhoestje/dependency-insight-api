package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.CiManagement;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface CiManagementArangoRepository extends ArangoRepository<CiManagement, String> {

}
