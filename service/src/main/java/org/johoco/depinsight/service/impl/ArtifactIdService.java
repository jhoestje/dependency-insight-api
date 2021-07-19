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

/**
 * 
 * 
 * @author John Hoestje
 *
 */
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
		ArtifactId save = artifactId;
		Optional<ArtifactId> existing = Optional.ofNullable(this.getByKey(artifactId.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

	@Override
	public ArtifactId getByKey(final ArtifactIdKey artifactIdKey) {
		return this.repository.getByKey(artifactIdKey).orElse(null);
	}

//	@Override
//	public ArtifactId getByArtifactId(final ArtifactId artifactId) {
//		return this.repository.get(artifactId).orElse(null);
//	}

	@Override
	public ArtifactId save(@NonNull final Language language, @NonNull final GroupId groupId,
			@NonNull final String artifactId) {
		ArtifactIdKey key = new ArtifactIdKey(language.getValue(), groupId.getValue(), artifactId);
		return this.save(new ArtifactId(key));
	}

}
