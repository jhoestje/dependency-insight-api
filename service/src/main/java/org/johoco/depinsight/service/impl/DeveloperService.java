package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.Developer;
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
	public Developer findOne(final Developer developer) {
		return this.repository.findOne(developer).orElse(null);
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
		Developer save = this.repository.findOne(developer).orElse(developer);
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

}
