package org.johoco.depinsight.repository.arangodb;

import java.util.Optional;

import org.johoco.depinsight.domain.Language;

import com.arangodb.springframework.repository.ArangoRepository;

public interface LanguageArangoRepository extends ArangoRepository<Language, String> {

	// @Query("MATCH (:Actor {name:$name})-[:ACTED_IN]->(m:Movie) return m")
	Optional<Language> findByValue(final String value) throws Exception;

}
