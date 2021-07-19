package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.repository.arangodb.LanguageArangoRepository;
import org.johoco.depinsight.service.ILanguageService;
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
public class LanguageService extends BaseService<Language> implements ILanguageService {

	private LanguageArangoRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(LanguageService.class);

	@Autowired
	public LanguageService(LanguageArangoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Iterable<Language> findAll() {
		return repository.findAll();
	}

	/**
	 * TODO: change exception to daoexception
	 */
	@Override
	public Language findByValue(String value) throws Exception {
		Optional<Language> lang = repository.findByValue(value);
		if (lang.isEmpty()) {
			LOGR.warn("An existing Language of {} wasn't findByValue", value);
			throw new Exception("no lanuage value for " + value);
		}
		return lang.get();
	}

	/**
	 * This needs to be protected so only an admin can perform it
	 */
//	@Override
//	public Language save(final Language language) {
//		// TODO: move to business rule
//		assert language.getValue() != null;
//		super.preSave(language);
//		// upsert
//		return repo.save(language);
//	}

	@Override
	public Language save(final Language language) {
		// TODO: move to business rule
		Language save = language;

		try {
			save = this.findByValue(language.getValue());
		} catch (Exception e) {
			LOGR.warn("An existing Language of {} wasn't found", language.getValue(), e);
		}
		super.preSave(save);

		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);

	}

}
