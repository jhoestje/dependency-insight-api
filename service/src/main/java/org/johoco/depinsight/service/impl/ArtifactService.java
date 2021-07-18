package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.repository.arangodb.extended.ArtifactRepository;
import org.johoco.depinsight.service.IArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtifactService extends BaseService<Artifact> implements IArtifactService {

	private ArtifactRepository repository;

	@Autowired
	public ArtifactService(final ArtifactRepository repository) {
		this.repository = repository;
	}

	// TODO Change to upsert??
	@Override
	public Artifact save(final Artifact artifact) {
		// TODO: move to business rule
//		assert artifact.getValue() != null;
		super.preSave(artifact);
		return repository.save(artifact);
	}

	@Override
	public Artifact find(final ArtifactKey key) {
		return this.repository.findByKey(key);
	}

}
