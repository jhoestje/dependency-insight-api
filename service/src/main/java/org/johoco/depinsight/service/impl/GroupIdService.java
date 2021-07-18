package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.key.GroupIdKey;
import org.johoco.depinsight.repository.arangodb.extended.GroupIdRepository;
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
		Optional<GroupId> existing = Optional.of(this.findByKey(groupId.getKey()));
		if (existing.isEmpty()) {
			return this.repository.save(groupId);
		}
		return existing.get();

//		return repository.save(groupId);
	}

	@Override
	public GroupId findByKey(final GroupIdKey key) {
		return repository.findByKey(key).get();
	}

	@Override
	public GroupId save(@NonNull final Language language, @NonNull final String groupId) {
		final GroupIdKey key = new GroupIdKey(language.getValue(), groupId);
		return this.save(new GroupId(key));

	}

}
