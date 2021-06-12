package org.johoco.depinsight.repository;

import org.johoco.depinsight.domain.relationship.OfArtifactId;

import com.arangodb.springframework.repository.ArangoRepository;

public interface OfArtifactIdRepository extends ArangoRepository<OfArtifactId, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
	//Optional<OfArtifactId> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
