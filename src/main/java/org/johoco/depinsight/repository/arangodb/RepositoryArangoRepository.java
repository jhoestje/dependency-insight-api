package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.Repository;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface RepositoryArangoRepository extends ArangoRepository<Repository, String> {

}
