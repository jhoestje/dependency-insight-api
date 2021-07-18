package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.composite.Artifact;

import com.arangodb.springframework.repository.ArangoRepository;

public interface ArtifactArangoRepository extends ArangoRepository<Artifact, String> {
	//Optional<Artifact> findByValue(final String value);

	// needs Query annotation
//	Artifact findByKey(final ArtifactKey key);
}
