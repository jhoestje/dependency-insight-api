package org.johoco.depinsight.repository;

import java.util.Optional;

import org.johoco.depinsight.domain.ArtifactId;

import com.arangodb.springframework.repository.ArangoRepository;

public interface ArtifactIdRepository extends ArangoRepository<ArtifactId, String> {
	Optional<ArtifactId> findByValue(final String value);
}
