package org.johoco.depinsight.repository.arangodb;

import java.util.Optional;

import org.johoco.depinsight.domain.Version;

import com.arangodb.springframework.repository.ArangoRepository;

public interface VersionArangoRepository extends ArangoRepository<Version, String> {
	Optional<Version> findByValue(final String value);
}
