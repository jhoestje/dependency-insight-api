package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Language;

public interface ILanguageService {
	Language save(final Language language);
	Iterable<Language> findAll();

	Language save(final Language language);
}
