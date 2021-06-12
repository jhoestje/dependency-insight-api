package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.repository.GroupIdRepository;
import org.johoco.depinsight.service.IGroupIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupIdService extends BaseService<GroupId> implements IGroupIdService {

	private GroupIdRepository repo;

	@Autowired
	public GroupIdService(final GroupIdRepository repo) {
		this.repo = repo;
	}

	@Override
	public Iterable<GroupId> findAll() {
		return repo.findAll();
	}

	@Override
	public GroupId save(final GroupId groupId) {
		// TODO: move to business rule
		assert groupId.getValue() != null;
		super.preSave(groupId);
		//upsert
		return repo.save(groupId);
//		Optional<GroupId> existing = repo.findByValue(groupId.getValue());
//		if (existing.isEmpty()) {
//			return repo.save(groupId);
//		}
//		return existing.get();
	}

	@Override
	public GroupId findGroupId(final String groupId) {
		return repo.findByValue(groupId).orElse(null);
	}

}
