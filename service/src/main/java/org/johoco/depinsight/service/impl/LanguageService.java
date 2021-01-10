package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.repository.LanguageRepository;
import org.johoco.depinsight.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService implements ILanguageService {

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
		Optional<Language> existing = repo.findByValue(language.getValue());
		if(existing.isEmpty()) {
			return repo.save(language);	
		}
		return existing.get();
	}

}
