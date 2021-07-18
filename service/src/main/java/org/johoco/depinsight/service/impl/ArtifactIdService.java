package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.key.ArtifactIdKey;
import org.johoco.depinsight.repository.arangodb.extended.ArtifactIdRepository;
import org.johoco.depinsight.service.IArtifactIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

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
		super.preSave(artifactId);
		Optional<ArtifactId> existing = Optional.of(this.findByKey(artifactId.getKey()));
		if (existing.isEmpty()) {
			return this.repository.save(artifactId);
		}
		return existing.get();

	}

	@Override
	public ArtifactId findByKey(final ArtifactIdKey artifactIdKey) {
		return this.repository.findByValue(artifactIdKey).orElse(null);
	}

	@Override
	public ArtifactId save(@NonNull final Language language, @NonNull final GroupId groupId,
			@NonNull final String artifactId) {
		ArtifactIdKey key = new ArtifactIdKey(language.getValue(), groupId.getValue(), artifactId);
		return this.save(new ArtifactId(key));
	}

}
