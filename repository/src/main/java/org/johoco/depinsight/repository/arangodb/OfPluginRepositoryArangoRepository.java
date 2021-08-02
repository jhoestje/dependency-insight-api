package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfPluginRepository;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfPluginRepositoryArangoRepository extends ArangoRepository<OfPluginRepository, String> {
}
