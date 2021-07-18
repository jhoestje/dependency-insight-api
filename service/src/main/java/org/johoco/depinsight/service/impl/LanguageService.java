package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.repository.arangodb.LanguageArangoRepository;
import org.johoco.depinsight.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService extends BaseService<Language> implements ILanguageService {

	private LanguageArangoRepository repo;

	@Autowired
	public LanguageService(LanguageArangoRepository repo) {
		this.repo = repo;
	}

	@Override
	public Iterable<Language> findAll() {
		return repo.findAll();
	}

	/**
	 * TODO: change exception to daoexception
	 */
	@Override
	public Language findByValue(String value) throws Exception {
		Optional<Language> lang = repo.findByValue(value);
		if (lang.isEmpty()) {
			throw new Exception("no lanuage for " + value);
		}
		return lang.get();
	}

	/**
	 * This needs to be protected so only an admin can perform it
	 */
	@Override
	public Language save(final Language language) {
		// TODO: move to business rule
		assert language.getValue() != null;
		super.preSave(language);
		// upsert
		return repo.save(language);
	}

}
