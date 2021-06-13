package org.johoco.depinsight.repository;

import org.johoco.depinsight.domain.GroupId;

import com.arangodb.springframework.repository.ArangoRepository;

public interface GroupIdRepository extends ArangoRepository<GroupId, String> {

//	Optional<GroupId> findByValue(@NonNull String groupId);
}
