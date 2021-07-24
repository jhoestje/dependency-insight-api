package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.Version;
import org.johoco.depinsight.domain.key.VersionKey;
import org.johoco.depinsight.repository.arangodb.extended.VersionRepository;
import org.johoco.depinsight.service.IVersionService;
import org.springframework.stereotype.Service;

import lombok.NonNull;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Service
public class VersionService extends BaseService<Version> implements IVersionService {

	private VersionRepository repository;

	public VersionService(final VersionRepository repository) {
		this.repository = repository;
	}

//	@Override
//	public Version save(@NonNull Version version) {
//		// TODO Auto-generated method stub
//		return repository.save(version);
//	}

//	@Override
//	public Optional<Version> findVersionByValue(final String version) {
//		return this.repository.findByValue(version);
//	}

	@Override
	public Version save(@NonNull final Version version) {

		// TODO: move to business rule
		Version save = version;
		Optional<Version> existing = Optional.ofNullable(this.getByKey(version.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

	@Override
	public Version save(@NonNull final Language language, @NonNull final GroupId groupId,
			@NonNull final ArtifactId artifactId, String version) {
		VersionKey key = new VersionKey(language.getValue(), groupId.getValue(), artifactId.getValue(), version);
		return this.save(new Version(key));
	}

	@Override
	public Version getByKey(final VersionKey versionKey) {
		return this.repository.getByKey(versionKey).orElse(null);
	}

}
