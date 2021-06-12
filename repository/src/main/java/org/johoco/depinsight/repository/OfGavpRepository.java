package org.johoco.depinsight.repository;

import org.johoco.depinsight.domain.relationship.OfGavp;

import com.arangodb.springframework.repository.ArangoRepository;

public interface OfGavpRepository extends ArangoRepository<OfGavp, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfGavp> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
