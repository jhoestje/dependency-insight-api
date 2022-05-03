package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfGavp;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfGavpArangoRepository extends ArangoRepository<OfGavp, String> {
}
