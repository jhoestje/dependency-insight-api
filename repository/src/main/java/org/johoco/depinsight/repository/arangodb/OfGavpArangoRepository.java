package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfGavp;

import com.arangodb.springframework.repository.ArangoRepository;

public interface OfGavpArangoRepository extends ArangoRepository<OfGavp, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfGavp> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}