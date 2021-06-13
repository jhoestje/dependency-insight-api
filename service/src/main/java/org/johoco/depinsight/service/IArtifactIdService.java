package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.ArtifactId;

import lombok.NonNull;

public interface IArtifactIdService {

	ArtifactId save(final ArtifactId artifactId);

	ArtifactId findArtifactId(final String value);

	ArtifactId save(final @NonNull String artifactId);
}
