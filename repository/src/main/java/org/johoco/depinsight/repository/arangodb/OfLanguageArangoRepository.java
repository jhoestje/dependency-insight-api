package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfLanguage;

import com.arangodb.springframework.repository.ArangoRepository;

public interface OfLanguageArangoRepository extends ArangoRepository<OfLanguage, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfLanguage> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
