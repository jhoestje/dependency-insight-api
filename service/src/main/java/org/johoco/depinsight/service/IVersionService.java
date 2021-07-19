package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.Version;
import org.johoco.depinsight.domain.key.VersionKey;

import lombok.NonNull;

public interface IVersionService {

	Version save(final @NonNull Version version);

	Version getByKey(final VersionKey versionKey);

	Version save(@NonNull final Language language, @NonNull final GroupId groupId, @NonNull final ArtifactId artifactId,
			String version);

//	Optional<Version> findVersionByValue(final String value);

//	Version save(@NonNull final Version version);
}
