package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.relationship.LanguageType;

public interface ILanguageTypeService {
	Iterable<LanguageType> findAll();

	LanguageType save(final LanguageType languageType);
}
