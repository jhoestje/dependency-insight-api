package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.GroupId;

public interface IGroupIdService {
	Iterable<GroupId> findAll();

	GroupId save(final GroupId groupdId);
	
	GroupId findGroupId(final String groupId);
}
