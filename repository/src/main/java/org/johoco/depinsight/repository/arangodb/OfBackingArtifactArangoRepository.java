package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfBackingArtifact;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfBackingArtifactArangoRepository extends ArangoRepository<OfBackingArtifact, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfBackingArtifact> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
