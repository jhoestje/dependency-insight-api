package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.key.GroupIdKey;
import org.johoco.depinsight.repository.GroupIdRepository;
import org.johoco.depinsight.service.IGroupIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class GroupIdService extends BaseService<GroupId> implements IGroupIdService {

	private GroupIdRepository repository;

	@Autowired
	public GroupIdService(final GroupIdRepository repository) {
		this.repository = repository;
	}

	@Override
	public GroupId save(final GroupId groupId) {
		// TODO: move to business rule
		assert groupId.getKey().getGroupIdValue() != null;
		super.preSave(groupId);
		// upsert
		return repository.save(groupId);
	}

	@Override
	public Optional<GroupId> findByGroupId(final String groupId) {
		return Optional.empty();// repository.findByValue(groupId).orElse(null);
	}

	@Override
	public GroupId save(@NonNull final Language language, @NonNull final String groupId) {
		Optional<GroupId> existing = this.findByGroupId(groupId);
		if (existing.isEmpty()) {
			final GroupIdKey key = new GroupIdKey(language.getValue(), groupId);
			GroupId gid = new GroupId(key);
			return this.repository.save(gid);
		}
		return existing.get();
	}

}
