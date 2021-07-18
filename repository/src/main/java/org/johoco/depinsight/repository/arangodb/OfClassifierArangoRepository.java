package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.relationship.OfClassifier;

import com.arangodb.springframework.repository.ArangoRepository;

public interface OfClassifierArangoRepository extends ArangoRepository<OfClassifier, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
//	Optional<OfClassifier> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
