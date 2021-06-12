package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.relationship.OfLanguage;

public interface IOfLanguageService {
	Iterable<OfLanguage> findAll();

	OfLanguage save(final OfLanguage languageType);
}
