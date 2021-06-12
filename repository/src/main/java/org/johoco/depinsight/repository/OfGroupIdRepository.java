package org.johoco.depinsight.repository;

import org.johoco.depinsight.domain.relationship.OfGroupId;

import com.arangodb.springframework.repository.ArangoRepository;

public interface OfGroupIdRepository extends ArangoRepository<OfGroupId, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfGroupId> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
