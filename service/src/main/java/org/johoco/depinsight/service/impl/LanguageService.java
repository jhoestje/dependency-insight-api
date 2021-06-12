package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.repository.LanguageRepository;
import org.johoco.depinsight.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService extends BaseService<Language> implements ILanguageService {

	private LanguageRepository repo;

	@Autowired
	public LanguageService(LanguageRepository repo) {
		this.repo = repo;
	}

	@Override
	public Iterable<Language> findAll() {
		return repo.findAll();
	}

	@Override
	public Language save(final Language language) {
		// TODO: move to business rule
		assert language.getValue() != null;
		super.preSave(language);
		//upsert
		return repo.save(language);
		
		
//		Optional<Language> existing = repo.findByValue(language.getValue());
//		if(existing.isEmpty()) {
//			return repo.save(language);	
//		}
//		return existing.get();
	}

}
