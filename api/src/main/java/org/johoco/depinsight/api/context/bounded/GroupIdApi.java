package org.johoco.depinsight.api.context.bounded;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.key.GroupIdKey;
import org.johoco.depinsight.service.IGroupIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupIdApi {

	private IGroupIdService service;

	@Autowired
	public GroupIdApi(final IGroupIdService service) {
		this.service = service;
	}

	public GroupId findByGroupId(final String language, final String groupId) {
		return service.findByGroupId(new GroupIdKey(language, groupId));
	}

	// this may need to get moved to a gateway
	public GroupId save(GroupId groupId) {
		return service.save(groupId);
	}

}
