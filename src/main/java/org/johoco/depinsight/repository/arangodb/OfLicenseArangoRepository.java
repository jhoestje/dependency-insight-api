package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfLicense;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfLicenseArangoRepository extends ArangoRepository<OfLicense, String> {
}
