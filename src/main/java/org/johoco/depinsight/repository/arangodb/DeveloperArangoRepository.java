package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.Developer;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface DeveloperArangoRepository extends ArangoRepository<Developer, String> {

}
