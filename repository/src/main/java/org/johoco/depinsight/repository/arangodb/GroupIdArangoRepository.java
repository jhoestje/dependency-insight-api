package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.GroupId;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface GroupIdArangoRepository extends ArangoRepository<GroupId, String> {

//	Optional<GroupId> findByValue(@NonNull String groupId);
}
