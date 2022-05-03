package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.IssueManagement;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IssueManagementArangoRepository extends ArangoRepository<IssueManagement, String> {

}
