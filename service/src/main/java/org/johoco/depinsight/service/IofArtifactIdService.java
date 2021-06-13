package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.relationship.OfArtifactId;

public interface IofArtifactIdService {

	OfArtifactId save(final OfArtifactId ofArtifactId);

	Iterable<OfArtifactId> findAll();

}
