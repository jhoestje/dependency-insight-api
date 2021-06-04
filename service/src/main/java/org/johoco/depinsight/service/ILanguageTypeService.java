package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.relationship.OfLanguage;

public interface ILanguageTypeService {
	Iterable<OfLanguage> findAll();

	OfLanguage save(final OfLanguage languageType);
}
