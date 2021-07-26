package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.License;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface LicenseArangoRepository extends ArangoRepository<License, String> {

}
