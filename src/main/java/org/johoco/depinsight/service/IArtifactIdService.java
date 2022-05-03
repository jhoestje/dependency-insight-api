package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.key.ArtifactIdKey;

import lombok.NonNull;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IArtifactIdService {

	ArtifactId save(final ArtifactId artifactId);

	ArtifactId save(@NonNull final Language language, @NonNull final GroupId groupId, @NonNull final String artifactId);

	ArtifactId getByKey(final ArtifactIdKey artifactIdKey);

}
