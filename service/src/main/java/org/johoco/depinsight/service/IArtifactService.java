package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;

public interface IArtifactService {

	Artifact save(final Artifact artifact);

	Artifact find(final ArtifactKey key);
}
