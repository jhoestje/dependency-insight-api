package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfRepository;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfRepositoryArangoRepository extends ArangoRepository<OfRepository, String> {
}
