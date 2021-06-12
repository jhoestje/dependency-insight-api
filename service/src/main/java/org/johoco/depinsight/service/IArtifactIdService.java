package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.ArtifactId;

public interface IArtifactIdService {

	ArtifactId save(final ArtifactId artifactId);
	
	ArtifactId findArtifactId(final String value);
}
