package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.PluginRepository;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface PluginRepositoryArangoRepository extends ArangoRepository<PluginRepository, String> {

}
