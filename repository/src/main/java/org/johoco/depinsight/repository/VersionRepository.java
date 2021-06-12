package org.johoco.depinsight.repository;

import java.util.Optional;

import org.johoco.depinsight.domain.Version;

import com.arangodb.springframework.repository.ArangoRepository;

public interface VersionRepository extends ArangoRepository<Version, String> {
	Optional<Version> findByValue(final String value);
}
