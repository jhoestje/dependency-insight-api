package org.johoco.depinsight.service;

import java.util.Optional;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;

import lombok.NonNull;

public interface IGroupIdService {
//	Iterable<GroupId> findAll();

	GroupId save(final GroupId groupdId);

	Optional<GroupId> findByGroupId(final String groupId);

	GroupId save(@NonNull final Language language, @NonNull final String groupId);
}
