package org.johoco.depinsight.repository;

import java.util.Optional;

import org.johoco.depinsight.domain.GroupId;

import com.arangodb.springframework.repository.ArangoRepository;

public interface GroupIdRepository extends ArangoRepository<GroupId, String> {
	Optional<GroupId> findByValue(final String value);
}
