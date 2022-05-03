package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IArtifactService {

	Artifact save(final Artifact artifact);

	Artifact getByKey(final ArtifactKey key);
}
