package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.repository.GroupIdRepository;
import org.johoco.depinsight.service.IGroupIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupIdService implements IGroupIdService {
	
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
		Optional<GroupId> existing = repo.findByValue(groupId.getValue());
		if(existing.isEmpty()) {
			return repo.save(groupId);	
		}
		return existing.get();
	}

	@Override
	public GroupId findGroupId(GroupId groupId) {
		return repo.findByValue(groupId.getValue()).orElse(null);
	}

}
