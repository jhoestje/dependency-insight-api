package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Repository;
import org.johoco.depinsight.domain.key.RepositoryKey;
import org.johoco.depinsight.repository.arangodb.extended.RepositoryRepository;
import org.johoco.depinsight.service.IRepositoryService;
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
public class RepositoryService extends BaseService<Repository> implements IRepositoryService {

	private RepositoryRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(RepositoryService.class);

	@Autowired
	public RepositoryService(RepositoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Repository save(@NonNull final Repository repository) {

		// TODO: move to business rule
		Repository save = repository;
		Optional<Repository> existing = Optional.ofNullable(this.getByKey(repository.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

//	@Override
//	public Repository save(@NonNull final Language language, @NonNull final GroupId groupId,
//			@NonNull final ArtifactId artifactId, String repository) {
//		RepositoryKey key = new RepositoryKey(language.getValue(), groupId.getValue(), artifactId.getValue(), repository);
//		return this.save(new Repository(key));
//	}

	@Override
	public Repository getByKey(final RepositoryKey repositoryKey) {
		return this.repository.getByKey(repositoryKey).orElse(null);
	}

}
