package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.repository.ArtifactIdRepository;
import org.johoco.depinsight.service.IArtifactIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtifactIdService extends BaseService<ArtifactId> implements IArtifactIdService {

	private ArtifactIdRepository repository;

	@Autowired
	public ArtifactIdService(final ArtifactIdRepository repository) {
		this.repository = repository;
	}

	@Override
	public ArtifactId save(final ArtifactId artifactId) {
		// TODO: move to business rule
		assert artifactId.getValue() != null;
		super.preSave(artifactId);
		return this.repository.save(artifactId);
//		Optional<ArtifactId> existing = this.repository.findByValue(artifactId.getValue());
//		if (existing.isEmpty()) {
//			return this.repository.save(artifactId);
//		}
//		return existing.get();
	}

	@Override
	public ArtifactId findArtifactId(final String artifactId) {
		return this.repository.findByValue(artifactId).orElse(null);
	}

}
