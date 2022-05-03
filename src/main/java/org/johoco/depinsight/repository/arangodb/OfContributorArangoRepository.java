package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfContributor;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfContributorArangoRepository extends ArangoRepository<OfContributor, String> {
}
