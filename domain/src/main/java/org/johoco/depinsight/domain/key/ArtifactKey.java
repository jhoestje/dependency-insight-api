package org.johoco.depinsight.domain.key;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.Version;

import lombok.Data;

/**
 * Unique identity for an Artifact.
 * 
 * @author John Hoestje
 *
 */
@Data
public class ArtifactKey implements Key {
	private GroupId groupId;
	private ArtifactId artifactId;
	private Version version;
	private Packaging packaging;
}
