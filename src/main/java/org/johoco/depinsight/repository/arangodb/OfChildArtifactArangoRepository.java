package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfChildArtifact;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * Using AQL literal queries instead of @Query annotation on the method in order
 * to be able to use the same query in the AQL query runner.
 * 
 * @author John Hoestje
 *
 */
public interface OfChildArtifactArangoRepository extends ArangoRepository<OfChildArtifact, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
	// Optional<OfArtifactId> findByGroupIdAndLanguage(final GroupId groupId, final
	// Language language);
}
