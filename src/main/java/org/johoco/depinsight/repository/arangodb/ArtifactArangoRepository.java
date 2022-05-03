package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.composite.Artifact;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * Using AQL literal queries instead of @Query annotation on the method in order
 * to be able to use the same query in the AQL query runner.
 * 
 * @author John Hoestje
 *
 */
public interface ArtifactArangoRepository extends ArangoRepository<Artifact, String> {
	// Optional<Artifact> findByValue(final String value);

	// needs Query annotation
//	Artifact findByKey(final ArtifactKey key);
}
