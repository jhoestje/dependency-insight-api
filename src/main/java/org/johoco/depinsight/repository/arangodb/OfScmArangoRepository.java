package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfScm;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfScmArangoRepository extends ArangoRepository<OfScm, String> {
}
