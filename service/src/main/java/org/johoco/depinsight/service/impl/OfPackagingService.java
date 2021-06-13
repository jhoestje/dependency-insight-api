package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfLanguage;
import org.johoco.depinsight.repository.OfLanguageRepository;
import org.johoco.depinsight.service.IofLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfPackagingService extends BaseService<OfLanguage> implements IofLanguageService {

	private OfLanguageRepository repo;

	@Autowired
	public OfPackagingService(OfLanguageRepository repo) {
		this.repo = repo;
	}

	@Override
	public Iterable<OfLanguage> findAll() {
		return repo.findAll();
	}

	@Override
	public OfLanguage save(final OfLanguage ofLanguage) {
		// TODO: move to business rule
//		assert ofLanguage.getValue() != null;
		// upsert
		super.preSave(ofLanguage);
		return repo.save(ofLanguage);
//		Optional<OfLanguage> existing = repo.findByGroupIdAndLanguage(ofLanguage.getGroupId(),
//				ofLanguage.getLanguage());
//		if (existing.isEmpty()) {
//			return repo.save(ofLanguage);
//		}
//		return existing.get();
	}

}
