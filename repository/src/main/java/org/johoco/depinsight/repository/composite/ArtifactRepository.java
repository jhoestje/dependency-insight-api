package org.johoco.depinsight.repository.composite;

import org.johoco.depinsight.domain.composite.Artifact;

import com.arangodb.springframework.repository.ArangoRepository;

public interface ArtifactRepository extends ArangoRepository<Artifact, String> {
	//Optional<Artifact> findByValue(final String value);

	// needs Query annotation
//	Artifact findByKey(final ArtifactKey key);
}
