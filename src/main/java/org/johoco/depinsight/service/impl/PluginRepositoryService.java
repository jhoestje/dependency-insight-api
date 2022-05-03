package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.PluginRepository;
import org.johoco.depinsight.domain.key.RepositoryKey;
import org.johoco.depinsight.repository.arangodb.extended.PluginRepositoryRepository;
import org.johoco.depinsight.service.IPluginRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class PluginRepositoryService extends BaseService<PluginRepository> implements IPluginRepositoryService {

	private PluginRepositoryRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(PluginRepositoryService.class);

	@Autowired
	public PluginRepositoryService(PluginRepositoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public PluginRepository save(@NonNull final PluginRepository repository) {

		// TODO: move to business rule
		PluginRepository save = repository;
		Optional<PluginRepository> existing = Optional.ofNullable(this.getByKey(repository.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

//	@Override
//	public PluginRepository save(@NonNull final Language language, @NonNull final GroupId groupId,
//			@NonNull final ArtifactId artifactId, String repository) {
//		PluginRepositoryKey key = new PluginRepositoryKey(language.getValue(), groupId.getValue(), artifactId.getValue(), repository);
//		return this.save(new PluginRepository(key));
//	}

	@Override
	public PluginRepository getByKey(final RepositoryKey repositoryKey) {
		return this.repository.getByKey(repositoryKey).orElse(null);
	}

}
