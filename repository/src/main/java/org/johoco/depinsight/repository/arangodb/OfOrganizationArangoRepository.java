package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfOrganization;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface OfOrganizationArangoRepository extends ArangoRepository<OfOrganization, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfGavp> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
