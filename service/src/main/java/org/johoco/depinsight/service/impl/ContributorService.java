package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Contributor;
import org.johoco.depinsight.repository.arangodb.extended.ContributorRepository;
import org.johoco.depinsight.service.IContributorService;
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
public class ContributorService extends BaseService<Contributor> implements IContributorService {

	private ContributorRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(ContributorService.class);

	@Autowired
	public ContributorService(ContributorRepository repository) {
		this.repository = repository;
	}

	/**
	 * TODO: change exception to daoexception
	 */
	@Override
	public Contributor findOne(final Contributor contributor) {
		return this.repository.findOne(contributor).orElse(null);

//		Optional<Contributor> dev = repository.getByKey(key);
//		if (dev.isEmpty()) {
//			LOGR.warn("An existing Contributor of {} wasn't getByKey", key);
//			throw new Exception("no Contributor key for " + key);
//		}
//		return dev.get();
	}

	/**
	 * This needs to be protected so only an admin can perform it
	 */
//	@Override
//	public Contributor save(final Contributor contributor) {
//		// TODO: move to business rule
//		assert contributor.getValue() != null;
//		super.preSave(contributor);
//		// upsert
//		return repo.save(contributor);
//	}

	@Override
	public Contributor save(final Contributor contributor) {
		// TODO: move to business rule
		Contributor save = contributor;
		Optional<Contributor> existing = Optional.ofNullable(this.findOne(contributor));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);

	}

}
