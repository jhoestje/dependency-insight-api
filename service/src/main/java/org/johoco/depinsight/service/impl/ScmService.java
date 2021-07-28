package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Scm;
import org.johoco.depinsight.domain.key.ScmKey;
import org.johoco.depinsight.repository.arangodb.extended.ScmRepository;
import org.johoco.depinsight.service.IScmService;
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
public class ScmService extends BaseService<Scm> implements IScmService {

	private ScmRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(ScmService.class);

	@Autowired
	public ScmService(ScmRepository repository) {
		this.repository = repository;
	}

	/**
	 * TODO: change exception to daoexception
	 */
	@Override
	public Scm getByKey(final ScmKey key) {
		return this.repository.getByKey(key).orElse(null);

//		Optional<Scm> dev = repository.getByKey(key);
//		if (dev.isEmpty()) {
//			LOGR.warn("An existing Scm of {} wasn't getByKey", key);
//			throw new Exception("no Scm key for " + key);
//		}
//		return dev.get();
	}

	/**
	 * This needs to be protected so only an admin can perform it
	 */
//	@Override
//	public Scm save(final Scm scm) {
//		// TODO: move to business rule
//		assert scm.getValue() != null;
//		super.preSave(scm);
//		// upsert
//		return repo.save(scm);
//	}

	@Override
	public Scm save(final Scm scm) {
		// TODO: move to business rule
		Scm save = scm;
		Optional<Scm> existing = Optional.ofNullable(this.getByKey(scm.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

}
