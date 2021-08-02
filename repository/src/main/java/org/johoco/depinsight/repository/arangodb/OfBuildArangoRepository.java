package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfBuild;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfBuildArangoRepository extends ArangoRepository<OfBuild, String> {
}
