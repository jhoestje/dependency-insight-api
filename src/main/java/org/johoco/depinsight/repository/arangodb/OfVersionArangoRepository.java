package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfVersion;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfVersionArangoRepository extends ArangoRepository<OfVersion, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfVersion> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
