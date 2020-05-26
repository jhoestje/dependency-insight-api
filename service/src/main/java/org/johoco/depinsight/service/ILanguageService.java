package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Language;

public interface ILanguageService {
	Iterable<Language> findAll();
}
