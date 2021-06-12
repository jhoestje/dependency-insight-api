package org.johoco.depinsight.repository;

import org.johoco.depinsight.domain.relationship.OfVersion;

import com.arangodb.springframework.repository.ArangoRepository;

public interface OfVersionRepository extends ArangoRepository<OfVersion, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfVersion> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
