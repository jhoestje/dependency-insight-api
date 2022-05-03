package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfIssueManagement;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfIssueManagementArangoRepository extends ArangoRepository<OfIssueManagement, String> {

}
