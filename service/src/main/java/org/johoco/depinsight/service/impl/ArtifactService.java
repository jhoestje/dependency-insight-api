package org.johoco.depinsight.service.impl;

import java.util.Optional;

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
		Artifact save = artifact;
		Optional<Artifact> existing = Optional.ofNullable(this.getByKey(artifact.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);

	}

	@Override
	public Artifact getByKey(final ArtifactKey artifactKey) {
		return this.repository.getByKey(artifactKey).orElse(null);
	}

//	@Override
//	public Artifact getByKey(final ArtifactKey key) {
//		return this.repository.findByKey(key);
//	}

}
