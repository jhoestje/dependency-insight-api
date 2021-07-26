package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Developer;
import org.johoco.depinsight.domain.key.DeveloperKey;
import org.johoco.depinsight.repository.arangodb.extended.DeveloperRepository;
import org.johoco.depinsight.service.IDeveloperService;
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
public class DeveloperService extends BaseService<Developer> implements IDeveloperService {

	private DeveloperRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(DeveloperService.class);

	@Autowired
	public DeveloperService(DeveloperRepository repository) {
		this.repository = repository;
	}

	/**
	 * TODO: change exception to daoexception
	 */
	@Override
	public Developer getByKey(final DeveloperKey key) {
		return this.repository.getByKey(key).orElse(null);

//		Optional<Developer> dev = repository.getByKey(key);
//		if (dev.isEmpty()) {
//			LOGR.warn("An existing Developer of {} wasn't getByKey", key);
//			throw new Exception("no Developer key for " + key);
//		}
//		return dev.get();
	}

	/**
	 * This needs to be protected so only an admin can perform it
	 */
//	@Override
//	public Developer save(final Developer developer) {
//		// TODO: move to business rule
//		assert developer.getValue() != null;
//		super.preSave(developer);
//		// upsert
//		return repo.save(developer);
//	}

	@Override
	public Developer save(final Developer developer) {
		// TODO: move to business rule
		Developer save = developer;
		Optional<Developer> existing = Optional.ofNullable(this.getByKey(developer.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

}
