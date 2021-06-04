package org.johoco.depinsight.repository;

import java.util.Optional;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.relationship.OfLanguage;

import com.arangodb.springframework.repository.ArangoRepository;

public interface LanguageTypeRepository extends ArangoRepository<OfLanguage, String> {
//	@Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol RETURN DISTINCT v")
	Optional<OfLanguage> findByGroupIdAndLanguage(final GroupId groupId, final Language language);
}
