package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.relationship.OfLanguage;

public interface IofLanguageService {
	OfLanguage save(final OfLanguage ofLanguage);

	Iterable<OfLanguage> findAll();
}
