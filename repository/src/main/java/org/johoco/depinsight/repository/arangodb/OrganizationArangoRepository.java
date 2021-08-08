package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.Organization;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OrganizationArangoRepository extends ArangoRepository<Organization, String> {

}
