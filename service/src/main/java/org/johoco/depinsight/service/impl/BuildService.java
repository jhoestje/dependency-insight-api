package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Build;
import org.johoco.depinsight.repository.arangodb.extended.BuildRepository;
import org.johoco.depinsight.service.IBuildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Service
public class BuildService extends BaseService<Build> implements IBuildService {

	private BuildRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(BuildService.class);

	@Autowired
	public BuildService(BuildRepository repository) {
		this.repository = repository;
	}

	/**
	 * TODO: change exception to daoexception
	 */
	@Override
	public Build findOne(final Build build) {
		return this.repository.findOne(build).orElse(null);

//		Optional<Build> dev = repository.getByKey(key);
//		if (dev.isEmpty()) {
//			LOGR.warn("An existing Build of {} wasn't getByKey", key);
//			throw new Exception("no Build key for " + key);
//		}
//		return dev.get();
	}

	/**
	 * This needs to be protected so only an admin can perform it
	 */
//	@Override
//	public Build save(final Build build) {
//		// TODO: move to business rule
//		assert build.getValue() != null;
//		super.preSave(build);
//		// upsert
//		return repo.save(build);
//	}

	@Override
	public Build save(final Build build) {
		// TODO: move to business rule
		Build save = build;
		Optional<Build> existing = Optional.ofNullable(this.findOne(build));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);

	}

}
