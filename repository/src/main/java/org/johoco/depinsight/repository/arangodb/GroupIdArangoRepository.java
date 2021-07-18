package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.GroupId;

import com.arangodb.springframework.repository.ArangoRepository;

public interface GroupIdArangoRepository extends ArangoRepository<GroupId, String> {

//	Optional<GroupId> findByValue(@NonNull String groupId);
}
