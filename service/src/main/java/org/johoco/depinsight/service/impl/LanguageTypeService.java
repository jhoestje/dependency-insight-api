package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.relationship.OfLanguage;
import org.johoco.depinsight.repository.LanguageTypeRepository;
import org.johoco.depinsight.service.ILanguageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageTypeService implements ILanguageTypeService {

	private LanguageTypeRepository repo;

	@Autowired
	public LanguageTypeService(LanguageTypeRepository repo) {
		this.repo = repo;
	}

	@Override
	public Iterable<OfLanguage> findAll() {
		return repo.findAll();
	}

	@Override
	public OfLanguage save(final OfLanguage languageType) {
		Optional<OfLanguage> existing = repo.findByGroupIdAndLanguage(languageType.getGroupId(),
				languageType.getLanguage());
		if (existing.isEmpty()) {
			return repo.save(languageType);
		}
		return existing.get();
	}

}
