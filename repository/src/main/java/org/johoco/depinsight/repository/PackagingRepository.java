package org.johoco.depinsight.repository;

import java.util.Optional;

import org.johoco.depinsight.domain.Packaging;

import com.arangodb.springframework.repository.ArangoRepository;

public interface PackagingRepository extends ArangoRepository<Packaging, String> {

	// @Query("MATCH (:Actor {name:$name})-[:ACTED_IN]->(m:Movie) return m")
	Optional<Packaging> findByValue(final String value);

}
