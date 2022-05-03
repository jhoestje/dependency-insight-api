package org.johoco.depinsight.repository;

import java.util.Optional;

import org.johoco.depinsight.domain.GroupId;
import org.springframework.data.repository.CrudRepository;

public interface GroupIdRepository extends CrudRepository<GroupId, String> {
	Optional<GroupId> findByValue(final String value);
}
