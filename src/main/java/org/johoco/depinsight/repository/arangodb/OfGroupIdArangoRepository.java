package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfGroupId;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfGroupIdArangoRepository extends ArangoRepository<OfGroupId, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfGroupId> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
