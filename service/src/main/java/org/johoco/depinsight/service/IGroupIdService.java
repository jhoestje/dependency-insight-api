package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.key.GroupIdKey;

import lombok.NonNull;

public interface IGroupIdService {

	GroupId save(final GroupId groupdId);

	GroupId getByKey(final GroupIdKey key);

	GroupId save(@NonNull final Language language, @NonNull final String groupId);

	GroupId getByGroupId(final GroupId groupId);
}
