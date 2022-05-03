package org.johoco.depinsight.service.impl;

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
	}

	@Override
	public Contributor save(final Contributor contributor) {
		Contributor save = this.repository.findOne(contributor).orElse(contributor);
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

}
