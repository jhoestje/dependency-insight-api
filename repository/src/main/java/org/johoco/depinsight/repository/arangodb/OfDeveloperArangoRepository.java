package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfDeveloper;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfDeveloperArangoRepository extends ArangoRepository<OfDeveloper, String> {
}
