package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.Contributor;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface ContributorArangoRepository extends ArangoRepository<Contributor, String> {

}
