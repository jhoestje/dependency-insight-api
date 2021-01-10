package org.johoco.depinsight.repository;

import java.util.Optional;

import org.johoco.depinsight.domain.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Long> {

	//@Query("MATCH (:Actor {name:$name})-[:ACTED_IN]->(m:Movie) return m")
	Optional<Language> findByValue(final String value);

}
