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

/**
 * 
 * 
 * @author John Hoestje
 *
 */
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
		GroupId save = groupId;
		Optional<GroupId> existing = Optional.ofNullable(this.getByKey(groupId.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

	@Override
	public GroupId getByKey(final GroupIdKey key) {
		return repository.getByKey(key).orElse(null);
	}

	@Override
	public GroupId getByGroupId(final GroupId groupId) {
		GroupId existing = null;
		if (groupId.getId() != null) {
			existing = this.repository.get(groupId).get();
		}
		if (groupId.getKey() == null) {
			existing = this.repository.getByKey(groupId.getKey()).get();
		}
		return existing;
	}

	@Override
	public GroupId save(@NonNull final Language language, @NonNull final String groupId) {
		final GroupIdKey key = new GroupIdKey(language.getValue(), groupId);
		return this.save(new GroupId(key));

	}

}
